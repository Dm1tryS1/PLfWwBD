package fourthTask.hospital

import java.util.*

fun main() {
    val hospital = Hospital(
        patients = createPatients(),
        doctors = createDoctors()
    )

    var input = showMenu(hospital)
    while (input.lowercase(Locale.getDefault()) != "exit") {
        input = showMenu(hospital)
    }
}

fun showMenu(hospital: Hospital): String {
    println("Choose action")
    println("1: Patient action")
    println("2: Doctor action")
    println("exit: For Exit")
    val input = readln()
    when (input.toIntOrNull() ?: 0) {
        1 -> hospital.choosePatientAction()
        2 -> hospital.chooseDoctorAction()
        else -> {}
    }
    return input
}

fun createPatients() = mutableListOf(
    Patient(
        fullName = "Patient 1",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 2",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 3",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 4",
        gender = false,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 5",
        gender = false,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 6",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 7",
        gender = false,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 8",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "PPatient 9",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 10",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 11",
        gender = false,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 12",
        gender = false,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 13",
        gender = true,
        patientState = PatientState.InHospital
    ),
    Patient(
        fullName = "Patient 14",
        gender = false,
        patientState = PatientState.InHospital
    )
)

fun createDoctors() = mutableListOf(
    Doctor(
        fullName = "Doctor 1",
        gender = true,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Surgeon)
    ),
    Doctor(
        fullName = "Doctor 2",
        gender = true,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Nurse)
    ),
    Doctor(
        fullName = "Doctor 3",
        gender = true,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Nurse)
    ),
    Doctor(
        fullName = "Doctor 4",
        gender = false,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Immunologist)
    ),
    Doctor(
        fullName = "Doctor 4",
        gender = false,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Physiotherapist, DoctorSpecialization.Surgeon)
    ),
    Doctor(
        fullName = "Doctor 6",
        gender = true,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Surgeon, DoctorSpecialization.Physiotherapist)
    ),
    Doctor(
        fullName = "Doctor 7",
        gender = false,
        doctorSpecialization = mutableListOf(DoctorSpecialization.Nurse)
    )
)

