package com.codeminds.temporaly.feature_example.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.codeminds.temporaly.R
import com.codeminds.temporaly.core.presentation.theme.TemporalyTheme
import com.codeminds.temporaly.feature_example.presentation.components.AutoResizedText
import com.codeminds.temporaly.feature_example.domain.model.TimerTypeEnum
import com.codeminds.temporaly.feature_example.presentation.components.BorderedIcon
import com.codeminds.temporaly.feature_example.presentation.components.CircleDot
import com.codeminds.temporaly.feature_example.presentation.components.CustomButton
import com.codeminds.temporaly.feature_example.presentation.components.InformationItem
import com.codeminds.temporaly.feature_example.presentation.components.TimerTypeItem

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = hiltViewModel()) {
    val timeState by remember { mutableStateOf(viewModel.timerValueState) }
    val timerTypeState by remember { mutableStateOf(viewModel.timerTypeState) }
    val roundsState by remember { mutableStateOf(viewModel.roundsState) }
    val todayTimeState by remember { mutableStateOf(viewModel.todayTimeState) }

    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(viewModel) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.getTimerSessionByDate()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(TemporalyTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                modifier = Modifier.size(TemporalyTheme.dimens.iconSizeNormal),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.primary
            )
        }
        AutoResizedText(
            text = "Focus Timer",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        Row {
            CircleDot()
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            CircleDot()
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(TemporalyTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )
        }
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        TimerSession(
            timer = viewModel.millisToMinutes(timeState.value),
            onIncreaseTap = {
                viewModel.onIncreaseTime()
            },
            onDecreaseTap = {
                viewModel.onDecreaseTime()
            }
        )
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        TimerTypeSession(
            type = timerTypeState.value,
            onTap = { type ->
                viewModel.onUpdateType(type)
            }
        )
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                text = "Start",
                textColor = MaterialTheme.colorScheme.background,
                buttonColor = MaterialTheme.colorScheme.primary,
                onTap = {
                    viewModel.onStartTimer()
                }
            )
            CustomButton(
                text = "Reset",
                textColor = MaterialTheme.colorScheme.primary,
                buttonColor = MaterialTheme.colorScheme.background,
                onTap = {
                    viewModel.onCancelTimer(true)
                }
            )
        }
        Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        InformationSession(
            modifier = Modifier.weight(1f),
            round = roundsState.value.toString(),
            time = viewModel.millisToHours(todayTimeState.value)
        )
    }
}

@Composable
fun TimerSession(
    modifier: Modifier = Modifier,
    timer: String,
    onIncreaseTap: () -> Unit = {},
    onDecreaseTap: () -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_minus, onTap = onDecreaseTap)
//            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        }
        AutoResizedText(
            text = timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .align(Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .align(Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderedIcon(icon = R.drawable.ic_plus, onTap = onIncreaseTap)
//            Spacer(modifier = Modifier.height(TemporalyTheme.dimens.spacerMedium))
        }
    }
}


@Composable
fun TimerTypeSession(
    modifier: Modifier = Modifier,
    type: TimerTypeEnum,
    onTap: (TimerTypeEnum) -> Unit = {}
) {
    val gridCount = 3
    val itemsSpacing = Arrangement.spacedBy(TemporalyTheme.dimens.paddingNormal)
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(TemporalyTheme.dimens.spacerLarge),
        columns = GridCells.Fixed(gridCount),
        horizontalArrangement = itemsSpacing,
        verticalArrangement = itemsSpacing,
    ) {
        items(
            TimerTypeEnum.values(),
            key = { it.title }
        ) {
            TimerTypeItem(
                text = it.title,
                textColor = if (type === it)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.secondary,
                onTap = {onTap(it)}
            )
        }
    }

}

@Composable
fun InformationSession(
    modifier: Modifier = Modifier,
    round: String,
    time: String,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            InformationItem(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = round,
                label = "rounds"
            )
            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            InformationItem(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                text = time,
                label = "time"
            )
        }
    }

}

@Preview(
    name = "HomeScreenPreview",
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    TemporalyTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun TimerSessionPreview(){
    TemporalyTheme {
        TimerSession(
            timer = "25:00"
        )
    }
}

@Preview
@Composable
fun TimerTypeSessionPreview() {
    TemporalyTheme {
        TimerTypeSession(
            type = TimerTypeEnum.FOCUS
        )
    }
}