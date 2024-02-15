package fourthTask.hospital

import fourthTask.Human

data class Patient(
    override var fullName: String,
    override val gender: Boolean,
    val listOfTreatment: MutableList<Treatment> = mutableListOf(),
    private var patientState: PatientState,
    private var doctor: Doctor? = null
) : Human() {
    fun chooseDoctor(doctors: List<Doctor>): Doctor? {
        println("Choose doctor")
        doctors.forEachIndexed { index, doctor ->
            println("${index + 1}: $doctor")
        }
        return readln().toIntOrNull()?.let { index ->
            doctors.getOrNull(index - 1)?.let {
                println("You chose doctor $it to patient: $this")
                it
            }
        }
    }

    fun chooseDoctorDialog(doctors: List<Doctor>) {
        checkState {
            chooseDoctor(doctors)?.let {
                this.doctor = it
            } ?: println("Wrong Input")
        }
    }

    fun checkState(action: () -> Unit) {
        if (patientState is PatientState.InHospital) {
            action()
        } else {
            println("Patient is not in hospital")
        }
    }


    fun changePatientState() {
        println("Choose state")
        println("1: Discharged")
        println("2: InHospital")
        when (readln().toIntOrNull() ?: 0) {
            1 -> createReason()
            2 -> patientState = PatientState.InHospital
            else -> {}
        }
    }

    private fun createReason() {
        println("Choose reason")
        println("1: Сured")
        println("2: KickedIOut")
        println("3: Another")
        when (readln().toIntOrNull() ?: 0) {
            1 -> patientState = PatientState.Discharged(ReasonDischarged.Сured(createReport()))
            2 -> patientState = PatientState.Discharged(ReasonDischarged.KickedIOut(createReport()))
            3 -> patientState = PatientState.Discharged(ReasonDischarged.Another(createReport()))
            else -> {}
        }
    }

    private fun createReport(): String {
        println("Send report")
        return readln()
    }

    fun getDoctor() = doctor

    fun getPatientState() = patientState

}

sealed class Treatment {

    abstract val doctor: Doctor

    data class Operation(override val doctor: Doctor) : Treatment()
    data class Procedure(override val doctor: Doctor) : Treatment()
    data class Medicines(override val doctor: Doctor) : Treatment()
}

sealed class PatientState {
    data class Discharged(val reason: ReasonDischarged) : PatientState()
    data object InHospital : PatientState()

}

sealed class ReasonDischarged {

    abstract val report: String

    data class Сured(override val report: String) : ReasonDischarged()

    data class KickedIOut(override val report: String) : ReasonDischarged()

    data class Another(override val report: String) : ReasonDischarged()
}