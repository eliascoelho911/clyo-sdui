package com.clyo.android.containers

import com.clyo.android.dsl.clyoDeclaration

val ContainersModule = clyoDeclaration {
    container<FeedbackContainerView>("feedback")
}