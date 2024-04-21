package com.example.tweets.ViewModels

import TweetsRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweets.models.Tweets
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class GetTweetsViewModel @Inject constructor(private val Tweets:TweetsRepository):ViewModel() {
    val Tweet:StateFlow<List<Tweets>>
         get() = Tweets.tweet
    init {
        viewModelScope.launch {
            Tweets.gettweets("Motivation")
        }
    }
}