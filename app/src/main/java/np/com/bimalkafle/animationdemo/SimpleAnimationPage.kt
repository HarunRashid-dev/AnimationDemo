package np.com.bimalkafle.animationdemo

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun SimpleAnimationPage(modifier: Modifier = Modifier){

    var scale = remember {
        Animatable(0f)
    }

    var animataAgain by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = animataAgain){
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 9000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )

    }

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            modifier = Modifier
                .size(200.dp)
                .weight(1f)
                .scale(scale.value)
            ,
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo"
        )
        Button(
            onClick = {
                GlobalScope.launch{
                    scale.snapTo(0f)
                }
                animataAgain = !animataAgain
            }
        ) {
            Text(text = "Animate")
        }
    }
}