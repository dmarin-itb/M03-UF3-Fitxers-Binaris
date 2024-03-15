package org.example

class Client {
    private var codi: Int = 0
    private var nom: String = ""
    private var cognoms: String = ""
    private var diaNaixement: Int = 0
    private var mesNaixement: Int = 0
    private var anyNaixement: Int = 0
    private var adrecaPostal: String = ""
    private var eMail: String = ""
    private var esVIP: Boolean = false

    constructor(){}

    constructor(codi:Int, nom:String, cognoms:String, diaNaixement:Int, mesNaixement:Int, anyNaixement:Int, adrecaPostal:String, eMail:String, esVIP:Boolean){
        this.codi = codi
        this.nom = nom
        this.cognoms = cognoms
        this.diaNaixement = diaNaixement
        this.mesNaixement = mesNaixement
        this.anyNaixement = anyNaixement
        this.adrecaPostal = adrecaPostal
        this.eMail = eMail
        this.esVIP = esVIP
    }

    fun getCodi(): Int {
        return codi
    }

    fun setCodi(codi: Int) {
        this.codi = codi
    }

    fun getNom(): String {
        return nom
    }

    fun setNom(nom: String) {
        this.nom = nom
    }

    fun getCognoms(): String {
        return cognoms
    }

    fun setCognoms(cognoms: String) {
        this.cognoms = cognoms
    }

    fun getDiaNaixement(): Int {
        return diaNaixement
    }

    fun setDiaNaixement(diaNaixement: Int) {
        this.diaNaixement = diaNaixement
    }

    fun getMesNaixement(): Int {
        return mesNaixement
    }

    fun setMesNaixement(mesNaixement: Int) {
        this.mesNaixement = mesNaixement
    }

    fun getAnyNaixement(): Int {
        return anyNaixement
    }

    fun setAnyNaixement(anyNaixement: Int) {
        this.anyNaixement = anyNaixement
    }

    fun getAdrecaPostal(): String {
        return adrecaPostal
    }

    fun setAdrecaPostal(adrecaPostal: String) {
        this.adrecaPostal = adrecaPostal
    }

    fun getEMail(): String {
        return eMail
    }

    fun setEMail(eMail: String) {
        this.eMail = eMail
    }

    fun getEsVIP(): Boolean {
        return esVIP
    }

    fun setEsVIP(esVIP: Boolean) {
        this.esVIP = esVIP
    }

    override fun toString(): String {
        return """
            Codi: ${this.codi}
            Nom: ${this.nom}
            Cognoms: ${this.cognoms}
            Data naixement: ${this.diaNaixement}/${this.mesNaixement}/${this.anyNaixement}
            Adreça postal: ${this.adrecaPostal}
            EMail: ${this.eMail}
            És VIP: ${this.esVIP}            
        """.trimIndent()
    }
}