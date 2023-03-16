package com.clyo.android

import android.view.View
import android.view.ViewGroup
import com.clyo.android.action.Action
import com.clyo.android.component.ComponentBinder
import com.clyo.android.component.ComponentName
import com.clyo.android.component.container.ContainerFactory
import com.clyo.android.component.container.ShowClyoScreen
import com.clyo.android.component.container.template.BaseTemplateData
import com.clyo.android.component.container.template.TemplateCreator
import com.clyo.android.component.widget.WidgetFactory
import kotlin.reflect.KClass

interface ClyoContext

fun ClyoContext.clyo(
    clyoDeclarations: ClyoDeclarations = emptyClyoDeclarations()
): Lazy<ClyoEngine> = lazy {
    ClyoEngine(
        showClyoScreen = ShowClyoScreen(
            widgetFactory = WidgetFactory(clyoDeclarations),
            containerFactory = ContainerFactory(clyoDeclarations)
        )
    )
}

interface ClyoDeclarations {
    fun putViewKClass(name: ComponentName, kClass: KClass<out View>)

    fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>)

    fun putAction(name: String, action: () -> Action)

    fun putAll(module: ClyoDeclarations)

    fun getViewKClassOrNull(name: ComponentName): KClass<out View>?

    fun getAllViewKClasses(): Map<ComponentName, KClass<out View>>

    fun getBinderOrNull(name: ComponentName): ComponentBinder<*>?

    fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>>

    fun getActionOrNull(name: String): Action?

    fun getAllActions(): Map<String, () -> Action>

    fun clear()
}

internal class ClyoDeclarationsImpl : ClyoDeclarations {

    private val viewKClassesMap = HashMap<ComponentName, KClass<out View>>()

    private val componentBindersMap = HashMap<ComponentName, () -> ComponentBinder<*>>()

    private val actionsMap = HashMap<String, () -> Action>()

    override fun putViewKClass(name: ComponentName, kClass: KClass<out View>) {
        viewKClassesMap[name] = kClass
    }

    override fun putBinder(name: ComponentName, binder: () -> ComponentBinder<*>) {
        componentBindersMap[name] = binder
    }

    override fun putAction(name: String, action: () -> Action) {
        actionsMap[name] = action
    }

    override fun putAll(module: ClyoDeclarations) {
        viewKClassesMap.putAll(module.getAllViewKClasses())
        componentBindersMap.putAll(module.getAllBinders())
        actionsMap.putAll(module.getAllActions())
    }

    override fun getViewKClassOrNull(name: ComponentName): KClass<out View>? {
        return viewKClassesMap[name]
    }

    override fun getAllViewKClasses(): Map<ComponentName, KClass<out View>> {
        return viewKClassesMap
    }

    override fun getBinderOrNull(name: ComponentName): ComponentBinder<*>? {
        return componentBindersMap[name]?.invoke()
    }

    override fun getAllBinders(): Map<ComponentName, () -> ComponentBinder<*>> {
        return componentBindersMap
    }

    override fun getActionOrNull(name: String): Action? {
        return actionsMap[name]?.invoke()
    }

    override fun getAllActions(): Map<String, () -> Action> {
        return actionsMap
    }

    override fun clear() {
        componentBindersMap.clear()
        viewKClassesMap.clear()
        actionsMap.clear()
    }
}

internal fun emptyClyoDeclarations(): ClyoDeclarations = ClyoDeclarationsImpl()

class ClyoEngine internal constructor(
    private val showClyoScreen: ShowClyoScreen,
    private val templateCreator: TemplateCreator
) {
    fun newTemplate(data: BaseTemplateData) {
        templateCreator(data)
    }

    fun render(data: BaseClyoData, container: ViewGroup) {
        showClyoScreen(data, container)
    }
}