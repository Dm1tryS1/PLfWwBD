package fourthTask.hospital

import kotlin.random.Random

data class Hospital(
    val id: Int = Random.nextInt(),
    val patients: MutableList<Patient> = mutableListOf(),
    val doctors: MutableList<Doctor> = mutableListOf(),
    private var state: HospitalState = HospitalState.Open
) {
    fun setState() {
        println("Choose State")
        println("1: Quarantine")
        println("2: Open")
        println("3: Close")
        when (readln().toIntOrNull() ?: 0) {
            1 -> state = HospitalState.Quarantine
            2 -> state = HospitalState.Open
            3 -> state = HospitalState.Close
            else -> {}
        }
    }

    fun chooseDoctorAction() {
        println("Choose doctor")
        doctors.forEachIndexed { index, doctor ->
            println("${index + 1}: $doctor")
        }
        readln().toIntOrNull()?.let { index ->
            doctors.getOrNull(index - 1)?.let {
                println("You chose doctor $it")
                chooseActionForDoctor(it)
            }
        }
    }

    private fun choosePatient(doctor: Doctor? = null): Patient? {
        println("Choose patient")
        val filterList = patients.filter { it.getDoctor()?.id == doctor?.id || doctor == null }
        if (filterList.isNotEmpty()) {
            filterList.forEachIndexed { index, d ->
                println("${index + 1}: $d")
            }
            return readln().toIntOrNull()?.let { index ->
                filterList.getOrNull(index - 1)?.let {
                    println("You chose patient $it")
                    it
                }
            }
        } else {
            println("This doctor has no patient")
            return null
        }
    }

    fun choosePatientAction() {
        choosePatient()?.let {
            println("Choose action for patient")
            println("1: Set doctor")
            println("2: Change patient state")
            when (readln().toIntOrNull() ?: 0) {
                1 -> it.chooseDoctorDialog(doctors)
                2 -> it.changePatientState()
                else -> {}
            }
        }
    }

    private fun chooseActionForDoctor(doctor: Doctor) {
        choosePatient(doctor)?.let {
            println("Choose action for doctor")
            println("1: Set Treatment")
            println("2: Delete Treatment")
            when (readln().toIntOrNull() ?: 0) {
                1 -> doctor.setTreatment(doctors, it)
                2 -> doctor.deleteTreatment(it)
                else -> {}
            }

        }
    }

    fun getState() = state
}

sealed class HospitalState {
    data object Quarantine : HospitalState()
    data object Open : HospitalState()
    data object Close : HospitalState()
}