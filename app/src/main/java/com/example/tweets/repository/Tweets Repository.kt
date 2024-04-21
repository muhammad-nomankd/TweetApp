
import com.example.tweets.TweetsApi
import com.example.tweets.models.Tweets
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsRepository @Inject constructor(private val tweetsApi: TweetsApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() = _categories
    private val _tweets= MutableStateFlow<List<Tweets>>(emptyList())
    val tweet:StateFlow<List<Tweets>>
        get() = _tweets
    suspend fun getCategories() {
        val response = tweetsApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun gettweets(category:String){
        val response=tweetsApi.getTweets("tweets[?(@.category==\"$category\")]")
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)

        }
    }
}
