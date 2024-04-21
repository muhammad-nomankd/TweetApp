package com.example.tweets.Screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tweets.R
import com.example.tweets.ViewModels.GetCategoriesViewModel

@Composable
fun CategoryScreen(){
    val categoriesViewModel: GetCategoriesViewModel= hiltViewModel()
    val category =categoriesViewModel.category.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp), verticalArrangement = Arrangement.SpaceAround) {
        items(category.value.distinct()){
            DetialScreen(category = it)
        }
    }

}
@Composable
fun DetialScreen(category:String){
    Box(modifier = Modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(8.dp))
        .size(160.dp)
        .paint(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop
        )
        .border(1.dp, color = Color(808080)), contentAlignment = Alignment.BottomCenter){
        Text(text = category, fontSize = 18.sp, color = Color.Black,modifier=Modifier.padding(0.dp,20.dp), style = MaterialTheme.typography.bodyMedium)
    }
}
@Preview
@Composable
fun Show(){
CategoryScreen()
    DetialScreen(category = "Motivation")
}