package com.example.compose.rally.ui.bills

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import com.example.compose.rally.R
import com.example.compose.rally.data.Bill
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.components.BillRow
import com.example.compose.rally.ui.components.StatementBody

/**
 * The Bills screen.
 */
@Composable
fun BillsScreen(
    bills: List<Bill> = remember { UserData.bills }
) {
    StatementBody(
        modifier = Modifier.clearAndSetSemantics { contentDescription = "Bills" },
        items = bills,
        amounts = { bill -> bill.amount },
        colors = { bill -> bill.color },
        amountsTotal = bills.map { bill -> bill.amount }.sum(),
        circleLabel = stringResource(R.string.due),
        row = { bill ->
            BillRow(bill.name, bill.due, bill.amount, bill.color)
        }
    )
}
