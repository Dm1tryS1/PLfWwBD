package fourthTask.hospital

import fourthTask.Human

data class Doctor(
    override val fullName: String,
    override val gender: Boolean,
    val doctorSpecialization: MutableList<DoctorSpecialization>
) : Human() {

    fun setTreatment(listOfDoctor: List<Doctor>, patient: Patient) {
        if (patient.getDoctor()?.id == id) {
            println("Choose treatment")
            println("1: Operation")
            println("2: Procedure")
            println("3: Medicines")
            when (readln().toIntOrNull() ?: 0) {
                1 -> patient.chooseDoctor(listOfDoctor.filter { it.doctorSpecialization.contains(DoctorSpecialization.Surgeon) })
                    ?.let {
                        Treatment.Operation(it)
                    }

                2 -> patient.chooseDoctor(listOfDoctor.filter { it.doctorSpecialization.contains(DoctorSpecialization.Nurse) })
                    ?.let {
                        Treatment.Operation(it)
                    }

                3 -> patient.chooseDoctor(listOfDoctor)?.let {
                    Treatment.Operation(it)
                }

                else -> {
                    null
                }
            }?.let {
                patient.listOfTreatment.add(it)
            }
        } else {
            println("This doctor is not for this patient")
        }

    }

    fun deleteTreatment(patient: Patient) {
        if (patient.listOfTreatment.size != 0) {
            println("Chose Patient Treatment")
            patient.listOfTreatment.forEachIndexed { index, treatment ->
                println("${index + 1}: $treatment")
            }
            readln().toIntOrNull()?.let { index ->
                patient.listOfTreatment.getOrNull(index - 1)?.let {
                    if (it.doctor.id == id || patient.getDoctor()?.id == id) {
                        patient.listOfTreatment.removeAt(index)
                    } else {
                        println("No permissions")
                    }
                }
            }

        } else {
            println("No treatment")
        }
    }
}

sealed class DoctorSpecialization {
    data object Surgeon : DoctorSpecialization()
    data object Nurse : DoctorSpecialization()
    data object Physiotherapist : DoctorSpecialization()
    data object Immunologist : DoctorSpecialization()

}