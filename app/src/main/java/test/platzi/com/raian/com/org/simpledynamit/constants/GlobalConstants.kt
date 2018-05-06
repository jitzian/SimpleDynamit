package test.platzi.com.raian.com.org.simpledynamit.constants

class GlobalConstants{
    companion object {
        //10.0.2.2 for Running in the emulator
        const val baseURLAuthorization : String = "http://10.0.2.2:3000"

        const val DEFAULT_OPTION_FOR_SELECT = " -- Select an Option -- "
        const val INPUT_CREDENTIALS_ERROR = "Credentials cannot be Empty"
        const val ERROR_CREDENTIALS_INVALID = "Credentials are invalid"
        const val BASE_URL_OPEN_AQ = "https://api.openaq.org"
        const val OPEN_AQ_CITIES_LIMIT = 2046
        const val MEASUREMENTS_FILTER = 10000
        const val URL_IMAGE_URL = "https://cdn.pixabay.com/photo/2012/05/07/18/01/buildings-48846_960_720.png"

        //Response codes
        const val STATUS_CODE_200 = 200
        const val STATUS_CODE_401 = 401

        //ERROR DESCRIPTIONS
        const val ERROR_ENTERED_CREDENTIALS_NOT_VALID = "CREDENTIALS NOT VALID"

    }
}