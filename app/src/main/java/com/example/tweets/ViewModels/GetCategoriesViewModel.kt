package com.example.tweets.ViewModels

import TweetsRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GetCategoriesViewModel @Inject constructor(private val Repository:TweetsRepository):ViewModel() {

    val category:StateFlow<List<String>>
        get() = Repository.categories

    init {
        viewModelScope.launch {
            Repository.getCategories()
        }
    }
}