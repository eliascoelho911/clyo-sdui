package com.clyo.android.containers

import com.clyo.android.dsl.clyoDeclarations

val ContainersModule = clyoDeclarations {
    container<ColumnContainerView>("column")
    container<FeedbackContainerView>("feedback")
}