package com.clyo.android

import com.clyo.android.action.Action
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.view.ColumnContainerView
import com.clyo.android.dsl.clyoDeclaration
import com.clyo.android.util.ViewProvider

interface ClyoContext

fun ClyoContext.clyo(
    clyoDeclaration: ClyoDeclaration = emptyClyoDeclaration()
): Lazy<ClyoEngine> = lazy {
    ClyoApplication.start(clyoDeclaration)

    ClyoEngine()
}

// TODO Refatorar
// TODO Deve ser safe LifeCycle
interface ClyoDeclaration {
    fun putViewProvider(name: ComponentName, viewProvider: ViewProvider)

    fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>)

    fun putAction(name: String, action: () -> Action)

    fun putAll(module: ClyoDeclaration)

    fun getViewProvider(name: ComponentName): ViewProvider

    fun getViewProviderOrNull(name: ComponentName): ViewProvider?

    fun getBinderOrNull(name: ComponentName): ComponentBinder<*>?

    fun getActionOrNull(name: String): Action?

    fun getAllViewProviders(): Map<ComponentName, ViewProvider>

    fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>>

    fun getAllActions(): Map<String, () -> Action>

    fun clear()
}

internal class ClyoDeclarationImpl : ClyoDeclaration {

    private val viewProvidersMap = HashMap<ComponentName, ViewProvider>()

    private val componentBindersMap = HashMap<ComponentName, () -> ComponentBinder<*>>()

    private val actionsMap = HashMap<String, () -> Action>()

    override fun putViewProvider(name: ComponentName, viewProvider: ViewProvider) {
        viewProvidersMap[name] = viewProvider
    }

    override fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAction(name: String, action: () -> Action) {
        actionsMap[name] = action
    }

    override fun putAll(module: ClyoDeclaration) {
        viewProvidersMap.putAll(module.getAllViewProviders())
        componentBindersMap.putAll(module.getAllBinders())
        actionsMap.putAll(module.getAllActions())
    }

    override fun getViewProvider(name: ComponentName): ViewProvider {
        return getViewProviderOrNull(name) ?: notFoundError("ViewProvider", name)
    }

    override fun getViewProviderOrNull(name: ComponentName): ViewProvider? {
        return viewProvidersMap[name]
    }

    override fun getBinderOrNull(name: ComponentName): ComponentBinder<*>? {
        return componentBindersMap[name]?.invoke()
    }

    override fun getActionOrNull(name: String): Action? {
        return actionsMap[name]?.invoke()
    }

    override fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>> {
        return componentBindersMap
    }

    override fun getAllViewProviders(): Map<ComponentName, ViewProvider> {
        return viewProvidersMap
    }

    override fun getAllActions(): Map<String, () -> Action> {
        return actionsMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewProvidersMap.clear()
        actionsMap.clear()
    }

    private fun notFoundError(type: String, name: ComponentName): Nothing {
        throw NoSuchElementException("$type $name has not been declared")
    }
}

internal fun emptyClyoDeclaration(): ClyoDeclaration = ClyoDeclarationImpl()

class ClyoEngine {
    internal val clyoDeclaration = ClyoApplication.clyoDeclaration
}

object ClyoApplication {
    private var privateClyoDeclaration: ClyoDeclaration? = null

    val clyoDeclaration: ClyoDeclaration
        get() = privateClyoDeclaration ?: error("Clyo is not started")

    fun start(clyoDeclaration: ClyoDeclaration, withDefaults: Boolean = true) {
        if (withDefaults) clyoDeclaration.putAll(ClyoDefault)

        this.privateClyoDeclaration = clyoDeclaration
    }

    fun close() {
        privateClyoDeclaration = null
    }
}

internal val ClyoDefault = clyoDeclaration {
    container<ColumnContainerView>("column")
}