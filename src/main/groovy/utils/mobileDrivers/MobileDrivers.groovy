package utils.mobileDrivers

import utils.dataUtils.CsvReader

/**
 * Created by himanshushivhare on 11-09-2015.
 */
class MobileDrivers {

    private String rootDir = new File(".").getCanonicalPath()
    public String csvDirectoryPath= rootDir + "/src/main/groovy/utils/mobileDrivers/MobileDrivers.csv".replace("/", File.separator)
    static List<Map> driverData = []
    static Integer randomNo = null

    public MobileDrivers() {
        driverData = getDriverData()
    }

    /**
     * Creates a map with the user details of a specific type of user
     * @param user - type of user. Currently, it is defaulted to 'default'
     * @return Map of user data
     */

    List getDriverData(){
        if(driverData.isEmpty()){
         //   String directoryPath1 = rootDir + "/src/main/groovy/utils/mobileDrivers/MobileDrivers.csv".replace("/", File.separator)
            driverData.add(getDriverDetailsFromCSV(csvDirectoryPath))
        }
        return driverData
    }

    /**
     * Creates a map with the user details of a specific type of user
     * @param user - type of user. Currently, it is defaulted to 'default'
     * @return
     */

    public def getDriverDetails(String driver = 'androidNexus5') {
        def userDetail
        userDetail = this.driverData.get(0).get(driver)
        return userDetail
    }



    /**
     * Creates a map of users from the UserDetails.csv
     * @param filePath - path of the UserDetails.csv file
     * @return
     */

    public def getDriverDetailsFromCSV(String filePath = csvDirectoryPath) {
        Map masterMap = [:]
        try{
            def headers
            new CsvReader(filePath).getRows().eachWithIndex{ line, lineNum ->
                //Fetching the headers
                if (lineNum == 0) {
                    headers = line
                    return
                }
                def driverDetailsMap = [:]
                def driverName

                //Fetching the data from each row
                line.iterator().eachWithIndex { value, index ->
                    if (index == 0) {
                        driverName = value
                    }
                    if(index < headers.size()){
                        driverDetailsMap.put(headers[index], value)
                    }
                }
                if(driverName.size()>0){
                    masterMap.put(driverName, driverDetailsMap)
                }
            }
        }
        catch(Exception e){
            throw e
        }
        return masterMap
    }
}