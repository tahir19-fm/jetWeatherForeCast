package com.example.jetweatherforecast.widgets

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.jetweatherforecast.R
import com.example.jetweatherforecast.model.WeatherItem
import com.example.jetweatherforecast.utils.formatDate
import com.example.jetweatherforecast.utils.formatDateTime
import com.example.jetweatherforecast.utils.formatDecimals


@Composable
fun WeatherDetailRow(weather: WeatherItem) {
    val imageUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}.png"
    Surface(
        Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color.White) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                formatDate(weather.dt)
                    .split(",")[0],
                modifier = Modifier.padding(start = 5.dp)
            )
            WeatherStateImage(imageUrl = imageUrl)
            Surface(modifier = Modifier.padding(0.dp),
                shape = CircleShape,
                color = Color(0xFFFFC400)
            ) {
                Text(weather.weather[0].description,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.caption)

            }
            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                    color = Color.Blue.copy(alpha = 0.7f),
                    fontWeight = FontWeight.SemiBold
                )
                ){
                    append(formatDecimals(weather.temp.max) + "º")

                }
                withStyle(
                    style = SpanStyle(
                        color = Color.LightGray)
                ){
                    append(formatDecimals(weather.temp.min) + "º")
                }
            })

        }


    }




}


@Composable
fun SunsetSunriseRow(weather: WeatherItem) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically) {


            Icon(
                painter = painterResource(id = R.drawable.sunrise), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(text = formatDateTime( weather.sunrise), style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically) {
            Text(text = formatDateTime( weather.sunset), style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))

            Icon(
                painter = painterResource(id = R.drawable.sunset), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }

    }
}

@Composable
fun HumiditywindPressure(weather: WeatherItem, isImperial: Boolean) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically) {


            Icon(
                painter = painterResource(id = R.drawable.humidity), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(text ="${weather.humidity}%", style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.pressure), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(text = "${weather.pressure} psi", style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.wind), contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(text ="${weather.speed} "+if(isImperial)"mph" else "m/s", style = MaterialTheme.typography.caption, modifier = Modifier.padding(4.dp))
        }

    }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl),
        contentDescription = "icon image",
        modifier = Modifier.size(80.dp)
    )
}
@Composable
fun ShowToast(context: Context, showIt: MutableState<Boolean>) {
    if (showIt.value) {
        Toast.makeText(context, " Added to Favorites",
            Toast.LENGTH_SHORT).show()
    }
}