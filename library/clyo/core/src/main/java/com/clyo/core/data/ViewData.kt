package com.clyo.core.data

interface ViewData{
    val name: ViewName
    val properties: ViewProperties
    val content: List<ViewData>
}