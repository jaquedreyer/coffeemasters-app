package com.dreyer.coffeemasters

import android.text.Layout.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dreyer.coffeemasters.ui.theme.Alternative1
import com.dreyer.coffeemasters.ui.theme.Alternative2


//@Preview (showBackground = true, widthDp = 400)
//@Composable
//fun Offer_Preview(){
//  Offer(title = "My title 1", description = "This is the description")
//}
@Preview(showBackground = true)
@Composable
fun OffersPage() {
    Column(
        Modifier.verticalScroll(rememberScrollState())
    ) {
        Offer(title = "Early Coffee", description = "10% off. Offer valid from 6am to 9am.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
        Offer(title = "Welcome Gift", description = "25% off on your first order.")
    }
}
@Composable
fun Offer(title:String, description: String = "") {
    Box(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.background_pattern),
            contentDescription = "Background pattern",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.matchParentSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative1)
                    .padding(16.dp)
            )
            //Spacer(modifier = Modifier.height(16.dp))

            Text(text = description,
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Alternative2)
                    .padding(16.dp)
            )
        }
    }

}