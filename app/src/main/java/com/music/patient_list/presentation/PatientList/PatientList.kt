package com.music.patient_list.presentation.PatientList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.music.patient_list.R
import com.music.patient_list.domain.model.PatientDetails
import com.music.patient_list.presentation.PatientDetails.PatientDetailsViewModel
import com.music.patient_list.presentation.components.PatientLazyColumn
import com.music.patient_list.presentation.components.TopAppBarState


val patients = listOf(
    PatientDetails(
        id = 1,
        name = "John Doe",
        age = 30,
        gender = "Male",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Headache, Fever"
    ),
    PatientDetails(
        id = 2,
        name = "Jane Smith",
        age = 25,
        gender = "Female",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Cough, Sore Throat"
    ),
    PatientDetails(
        id = 3,
        name = "Bob Johnson",
        age = 25,
        gender = "Male",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Fatigue, Muscle Pain"
    ),
    PatientDetails(
        id = 4,
        name = "Alice Brown",
        age = 28,
        gender = "Female",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Nausea, Dizziness"
    ),
    PatientDetails(
        id = 5,
        name = "Mike Davis",
        age = 35,
        gender = "Male",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Back Pain, Headache"
    ),
    PatientDetails(
        id = 6,
        name = "Emily Taylor",
        age = 22,
        gender = "Female",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Sore Throat, Runny Nose"
    ),
    PatientDetails(
        id = 7,
        name = "Sarah Lee",
        age = 38,
        gender = "Female",
        doctorAssigned = "Johny Sins",
        doctorPrescription = "Fatigue, Joint Pain"
    ),

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientList(
    scrollBehavior: TopAppBarScrollBehavior,
    onItemClicked:(Int) -> Unit,
    onFABClicked: () -> Unit,
    viewModel: PatientListViewModel = hiltViewModel()
) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopAppBarState(scrollBehavior = scrollBehavior,
                onBackButtonClicked = {}, title = "Patient List"
            )

            PatientLazyColumn(modifier = Modifier, patients, {onItemClicked(it)})
        }
        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp),
            onClick = {onFABClicked()}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = "Add patient"
            )
        }
    }
}




//@Preview
//@Composable
//fun DefaultPreview() {
//    PatientList(sc)
//}