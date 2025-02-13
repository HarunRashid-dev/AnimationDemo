package np.com.bimalkafle.animationdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAnimationPage(modifier: Modifier = Modifier){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier.size(200.dp)
                .weight(1f),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Button(
            onClick = {

            }
        ) {
            Text(text = "Animate")
        }
    }
}