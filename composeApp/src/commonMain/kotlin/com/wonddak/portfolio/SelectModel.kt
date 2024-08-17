package com.wonddak.portfolio

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.wonddak.portfolio.model.ProjectType

class SelectModel : ViewModel() {
    var nowType by mutableStateOf(ProjectType.App)
        private set

    fun updateNowType(type: ProjectType) {
        println("update Type to $type")
        this.nowType = type
    }


}