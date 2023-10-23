package com.example.smda2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smda2.ui.theme.SMDA2Theme





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SMDA2Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primaryVariant) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main_screen") {
                        composable("main_screen") { WeatherUI(navController) }
                        composable("second_screen") { SecondScreen(navController) }
                    }
                }
            }
        }

    }
}
@Composable
fun WeatherUI(navController: NavController) {

    BackgroundImage()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.padding(start = 4.dp)
            )
            {
                Icon(
                    Icons.Default.List,
                    contentDescription = "Drawer",
                    modifier = Modifier.clickable {
                        navController.navigate("second_screen")
                    }
                )
                Text(
                    "MUMBAI",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row {
                Icon(Icons.Default.Search, contentDescription = "Search Icon", modifier = Modifier.padding(end = 4.dp))
                Icon(Icons.Default.Settings, contentDescription = "Settings Icon", modifier = Modifier.padding(end = 4.dp))
            }

        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .background(color = Color.Transparent)
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row (
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text("28°", fontWeight = FontWeight.Bold, fontSize = 48.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("C", fontWeight = FontWeight.Normal, fontSize = 18.sp)
                    Text("SUNNY", fontWeight = FontWeight.Medium, fontSize = 18.sp)
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text("13 FEB, SAT", fontWeight = FontWeight.Normal, fontSize = 14.sp)
                Text("02:00 PM", fontWeight = FontWeight.Normal, fontSize = 14.sp)
            }
        }


        Box (
                modifier = Modifier.fillMaxSize()
        ) {


         Box(
            modifier = Modifier
                .background(color = White)
                .padding(20.dp)
                .align(Alignment.BottomStart),
            // Apply white background
        )
        {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween


                ) {
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.sunny),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.cloudy),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.rain),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier.size(40.dp),
                        painter = painterResource(id = R.drawable.cloudy),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.sunny),
                        contentDescription = null,
                    )

                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Add weather icons and temperatures for the week here
                    Text("SAT", style = TextStyle(color = Red))
                    Text("SUN", style = TextStyle(color = Black))
                    Text("MON", style = TextStyle(color = Black))
                    Text("TUE", style = TextStyle(color = Black))
                    Text("WED", style = TextStyle(color = Black))
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Add weather icons and temperatures for the week here
                    Text("28", style = TextStyle(color = Red))
                    Text("31", style = TextStyle(color = Black))
                    Text("32", style = TextStyle(color = Black))
                    Text("32", style = TextStyle(color = Black))
                    Text("32", style = TextStyle(color = Black))
                }
            }
        }
        }

    }
}


@Composable
fun BackgroundImage() {
    val backgroundImage = painterResource(id = R.drawable.background)
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = backgroundImage,
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

    }
}


@Composable
fun SecondScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(200.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
            modifier = Modifier.weight(2f),
        )
            {
                Row()
                {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.padding(start = 8.dp, top = 16.dp).clickable { navController.popBackStack() },
                        tint = Gray
                    )
                    Column {
                        Text(
                            "LOCATIONS",
                            fontSize = 18.sp,
                            style = TextStyle(color = Black),
                            modifier = Modifier.padding(start = 8.dp, top = 16.dp)
                        )
                        Text(

                            buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Black))
                                {
                                    append("You are currently getting results for popular places from ")
                                }
                                withStyle(style = SpanStyle(color = Color(0xFFf569ad))) {
                                    append("India")
                                }
                            },
                            modifier = Modifier.padding(top = 32.dp)
                        )

                        Column(
                        )
                        {
                            Button(
                                onClick = {},
                                modifier = Modifier.padding(top = 16.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFEae5e5)),
                                shape = RoundedCornerShape(16.dp)

                            ) {
                                Text("Choose place", style = TextStyle(Color(0xFF534bce)))
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color(0xFFEae5e5)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            )
            {
                    Icon(Icons.Default.Add, contentDescription = "Add Place", tint = Color(0xFF5c5d66))
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "ADD PLACE",
                        style = TextStyle(color = Color(0xFF5c5d66)),
                        fontWeight = FontWeight.Bold
                    )

            }
        }

            FirstLocationItem("Mumbai", "28, Sunny", "Humidity : 51%")
            LocationItem("Indore", "24, Smoke", "Humidity : 35%")
            LocationItem("Bhopal", "21, Clear", "Humidity : 35%")
        }
    }


@Composable
fun FirstLocationItem(city: String, weather: String, humidity: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF534bce))
            .padding(16.dp)
            .padding(top = 24.dp)
            .padding(bottom = 24.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(city, fontWeight = FontWeight.Light, fontSize = 24.sp, style = TextStyle(color = White))
            Text(humidity, style = TextStyle(Color(0xFFEae5e5)))
        }
        Text(weather, color = Color(0xFFf569ad))
    }
}

@Composable
fun LocationItem(city: String, weather: String, humidity: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = White)
            .padding(16.dp)
            .padding(top = 24.dp)
            .padding(bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(city, fontWeight = FontWeight.Light, fontSize = 24.sp, style = TextStyle(color = Black))
            Text(humidity, style = TextStyle(Color(0xFFB3aeae)))
        }
        Text(weather, color = Color(0xFF534bce))
    }
}
