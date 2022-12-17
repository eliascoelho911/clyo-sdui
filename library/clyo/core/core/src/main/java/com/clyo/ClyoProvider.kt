package com.clyo

/**
 * Tem a responsabilidade de prover uma instância de [Clyo]
 */
object ClyoProvider {
    private var mInstance: Clyo? = null

    /**
     * Retorna a instancia de [Clyo]. Cria se ainda não existir
     * @return [Clyo]
     */
    fun getOrCreate(): Clyo {
        if (mInstance == null) create()
        return mInstance!!
    }

    /**
     * Cria o [Clyo] se ele ainda não estiver inicializado
     */
    private fun create() {
        if (mInstance == null)
            mInstance = Clyo()
    }

    /**
     * Interrompe o funcionamento do [Clyo]
     */
    fun stopClyo() {
        mInstance?.stop()
        mInstance = null
    }
}