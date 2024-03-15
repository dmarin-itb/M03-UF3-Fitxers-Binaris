package org.example

import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

//objecte File per poder accedir al fitxer 'físic'
val fitxer:File = File("dadesClients.bin")

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
//    escripturaFitxer()

    var llistatClients = recuperarDades()

    do {
        var sortida = false
        when(val opc = menu()){
            1 -> altaClient(llistatClients)
            /*2 -> consultaPosicio()
            3 -> consultaCodi()
            4 -> modificarClient()
            5 -> esborrarClient()*/
            6 -> llistarClients(llistatClients)
            0 -> sortida = true
        }
    } while(!sortida)

    guardarDades(llistatClients)
}

fun menu():Int {
    println("### MENÚ ###")
    println("""
        1. Alta d'un client
        2. Consulta per posició
        3. Consulta per codi
        4. Modificació d'un client
        5. Eliminació d'un client
        6. Llistar clients
        0. Sortir
    """.trimIndent())
    return readInt("Tria una opció", "Ha de ser numèric", "Les opcions son entre 0 i 6", 0, 6)
}

fun recuperarDades(): MutableList<Client>{
    val llistatClients = mutableListOf<Client>()

    if(!fitxer.exists()){
        println("EL FITXER DE DADES NO EXISTEIX!!")
    } else {
        val fis: FileInputStream = FileInputStream(fitxer)
        val dis: DataInputStream = DataInputStream(fis)
        while(dis.available()>0){
            val codi = dis.readInt()
            val nom = dis.readUTF()
            val cognoms = dis.readUTF()
            val diaNaixement = dis.readInt()
            val mesNaixement = dis.readInt()
            val anyNaixement = dis.readInt()
            val adrecaPostal = dis.readUTF()
            val eMail = dis.readUTF()
            val esVIP = dis.readBoolean()

            val client:Client = Client(codi, nom, cognoms, diaNaixement, mesNaixement, anyNaixement, adrecaPostal, eMail, esVIP)

            llistatClients.add(client)
        }
        dis.close()
    }
    return llistatClients
}

fun altaClient(llistatClients: MutableList<Client>){
    val codi = readInt("Introdueix el codi del client", "El tipus de dades és numèric sencer", "El valor mínim és 0", 0)
    val nom = readWord("Introdueix el nom del client", "El tipus de dades és text")
    val cognoms = readWord("Introdueix els cognoms del client", "El tipus de dades és text")
    val diaNaixement = readInt("Introdueix el dia de naixement del client", "El tipus de dades és numèric sencer", "El valor mínim és 1 i el màxim 31", 1, 31)
    val mesNaixement = readInt("Introdueix el mes de naixement del client", "El tipus de dades és numèric sencer", "El valor mínim és 1 i el màxim 12", 1, 12)
    val anyNaixement = readInt("Introdueix l'any de naixement del client", "El tipus de dades és numèric sencer", "El valor mínim és 1899 i el màxim és 2024", 1899, 2024)
    val adrecaPostal = readWord("Introdueix l'adreça del client", "El tipus de dades és text")
    val eMail = readWord("Introdueix el correu electrònic del client", "El tipus de dades és text")
    val esVIP = readBoolean("Introdueix si l'usuari és VIP", "El tipus de dades és booleà: true/false")

    val client:Client = Client(codi, nom, cognoms, diaNaixement, mesNaixement, anyNaixement, adrecaPostal, eMail, esVIP)

    llistatClients.add(client)
}

fun llistarClients(llistatClients: MutableList<Client>){
    for(c in llistatClients){
        println(c)
    }
}

fun guardarDades(llistatClients: MutableList<Client>){
    val fos:FileOutputStream = FileOutputStream(fitxer)
    val dos = DataOutputStream(fos)

    for(c in llistatClients){
        dos.writeInt(c.getCodi())//codi
        dos.writeUTF(c.getNom())//nom
        dos.writeUTF(c.getCognoms())//cognoms
        dos.writeInt(c.getDiaNaixement())//dia
        dos.writeInt(c.getMesNaixement())//mes
        dos.writeInt(c.getAnyNaixement())//any
        dos.writeUTF(c.getAdrecaPostal())//adreça postal
        dos.writeUTF(c.getEMail())//email
        dos.writeBoolean(c.getEsVIP())//és VIP
    }
    dos.flush()
    dos.close()
}

fun escripturaFitxer(){
    val fos:FileOutputStream = FileOutputStream(fitxer)
    val dos = DataOutputStream(fos)

    dos.writeInt(1)//codi
    dos.writeUTF("Antonio")//nom
    dos.writeUTF("Fernandez")//cognoms
    dos.writeInt(3)//dia
    dos.writeInt(12)//mes
    dos.writeInt(1967)//any
    dos.writeUTF("Calle Falsa, 123")//adreça postal
    dos.writeUTF("antonio.fernandez@fakemail.com")//email
    dos.writeBoolean(true)//és VIP

    dos.writeInt(2)//codi
    dos.writeUTF("Pedro")//nom
    dos.writeUTF("Blanco")//cognoms
    dos.writeInt(12)//dia
    dos.writeInt(5)//mes
    dos.writeInt(1973)//any
    dos.writeUTF("Calle Falsa, 124")//adreça postal
    dos.writeUTF("pedro.blanco@fakemail.com")//email
    dos.writeBoolean(true)//és VIP

    dos.flush()
}