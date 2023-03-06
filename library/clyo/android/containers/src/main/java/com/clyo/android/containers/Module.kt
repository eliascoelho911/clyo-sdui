package com.clyo.android.containers

import com.clyo.android.dsl.clyoComponents

val ContainersModule = clyoComponents {
    container<ColumnContainerView>("column")
    container<FeedbackContainerView>("feedback")
}