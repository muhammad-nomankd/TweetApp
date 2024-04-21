import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweets.ViewModels.GetTweetsViewModel

@Composable
fun DetailScreen() {
    val tweetViewModel: GetTweetsViewModel = hiltViewModel()

    val tweetsState = tweetViewModel.Tweet.collectAsState()

    LazyColumn {
        items(tweetsState.value) { tweet ->
            TweetListItem(tweet = tweet.toString())
        }
    }
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(1.dp, color = Color.Gray)
    ) {
        Text(
            text = tweet,
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}
