/*
 * Copyright (C) 2022, Yury Halubets
 * All rights reserved.
 */
package com.yuryhalubets.feature.coin.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.google.accompanist.flowlayout.FlowRow
import com.yuryhalubets.feature.coin.detail.components.CoinTag
import com.yuryhalubets.feature.coin.detail.components.TeamListItem
import com.yuryhalubets.feature.coin.detail.vm.CoinDetailState
import com.yuryhalubets.components.CenterCircularProgressBar
import com.yuryhalubets.components.ErrorText
import com.yuryhalubets.core.ui.Dimens
import com.yuryhalubets.core.ui.R as CoreR

@Composable
fun CoinDetailScreen(
    state: CoinDetailState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (state) {
            is CoinDetailState.Loading -> CenterCircularProgressBar()
            is CoinDetailState.Failure -> ErrorText(errorMessage = state.errorMessage)
            is CoinDetailState.Success -> state.data.let { coin ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(Dimens.spacingLarge)
                ) {
                    item {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                // Probably will be better to calculate it in VM
                                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                                style = MaterialTheme.typography.h2,
                                modifier = Modifier.weight(8f)
                            )
                            Text(
                                text = if (coin.isActive) stringResource(CoreR.string.active)
                                else stringResource(CoreR.string.inactive),
                                color = if (coin.isActive) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .weight(2f)
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.largeSpacerHeight))
                        Text(
                            text = coin.description,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(Dimens.largeSpacerHeight))
                        Text(

                            text = stringResource(R.string.tags),
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(Dimens.largeSpacerHeight))
                        FlowRow(
                            mainAxisSpacing = Dimens.generalAxis,
                            crossAxisSpacing = Dimens.generalAxis,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            coin.tags.forEach { tag ->
                                CoinTag(tag = tag)
                            }
                        }
                        Spacer(modifier = Modifier.height(Dimens.largeSpacerHeight))
                        Text(
                            text = stringResource(R.string.team_members),
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(Dimens.largeSpacerHeight))
                    }
                    items(coin.team) { teamMember ->
                        TeamListItem(
                            teamMember = teamMember,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(Dimens.spacingMiddle)
                        )
                        Divider()
                    }
                }
            }
        }
    }
}