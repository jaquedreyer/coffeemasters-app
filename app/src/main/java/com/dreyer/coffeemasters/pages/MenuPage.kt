package com.dreyer.coffeemasters.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dreyer.coffeemasters.DataManager
import com.dreyer.coffeemasters.Product
import com.dreyer.coffeemasters.R



@Composable
fun MenuPage(dataManager: DataManager) {
    LazyColumn {
        items(dataManager.menu) {
            Text(it.name,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 10.dp))
            it.products.forEach {
            Card(
                //elevation = 2.dp,
                elevation = CardDefaults.outlinedCardElevation(2.dp),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(12.dp)
            ) {
                ProductItem(it, onAdd = {
                    dataManager.cartAdd(it)
                })
                }
            }
        }
    }
}



//a function that extends Double
//to format the digits
fun Double.format(digits: Int) = "%.${digits}f".format(this)

@Composable
fun ProductItem(product: Product, onAdd: (Product)->Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {

        AsyncImage(
            model = product.imageUrl,
            contentDescription = "Image for ${product.name}",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(product.name, fontWeight = FontWeight.Bold)
                Text("$${product.price.format(2)} ea")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    //backgroundColor = Alternative1,
                    contentColor = Color.White
                ),
                onClick = {
                    onAdd(product)
                },
            ) {
                Text("Add")
            }
        }
    }
}