package utils.dataUtils

import au.com.bytecode.opencsv.CSVReader

/**
 * Created with IntelliJ IDEA.
 * User: varunm
 * Date: 8/7/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 * This class helps in reading csv files. Any kind of delimiter and quote character can be used to store data.
 * This file provide provision to mention the delimiter and quote char during object creation.
 */
class CsvReader {

    CSVReader csvReader = null
    List<List> rows=null

    /**
     * Creates the CsvReader class object
     * @param filePath - File path of the csv file to be read
     * @param separator - Data separator to be used. Default value is ','
     * @param quotechar - Quote character for the data. Default value is '"'
     * @throws Exception
     */
    public CsvReader(String filePath, char separator = ',', char quotechar = '"') throws Exception{
        this(new FileReader(filePath),separator,quotechar)
    }

    /**
     * Creates the CsvReader class object
     * @param inpFile - Input csv file to be read
     * @param separator - Data separator to be used. Default value is ','
     * @param quotechar - Quote character for the data. Default value is '"'
     * @throws Exception
     */
    public CsvReader(File inpFile , char separator = ',', char quotechar = '"') throws Exception{
        this(new FileReader(inpFile),separator,quotechar)
    }

    /**
     * Creates the CsvReader class object
     * @param reader - Reader object of the file to be read
     * @param separator - Data separator to be used. Default value is ','
     * @param quotechar - Quote character for the data. Default value is '"'
     * @throws Exception
     */
    public CsvReader(Reader reader , char separator = ',', char quotechar = '"') throws Exception{
        csvReader = new CSVReader(reader,separator,quotechar)
        List<String[]> rowsTemp = csvReader.readAll()
        rows = new ArrayList<List>()
        Iterator<String[]> rowsIterator = rowsTemp.iterator()
        // handling empty lines from csv by adding only non-empty lines to rows
        while (rowsIterator.hasNext()) {
            List tempList = Arrays.asList(rowsIterator.next())
            if (!(tempList.size() == 1 && tempList.getAt(0).equals(""))) {
                rows.add(tempList)
            }
        }
    }

    /**
     * Gets the data from csv file based on column and row number
     * @param column - column number
     * @param row - row number
     * @return - the data at the said position. If the said row or column don't exists then return an empty string
     */
    public String getData(int column,int row){
        String data=null
        if(row < 0 && (row > rows.size())){
            return ""
        }
        List rowData= rows.get(row)
        if(column < 0 || ((column + 1) > rowData.size())){
            return ""
        }

        data=rowData.get(column)

        return data
    }

    /**
     * Get the number of rows in the said csv file
     * @return
     */
    public int getNoOfRows(){
        return rows.size()
    }

    /**
     * Return the number of column in the first row of the csv file
     * @return
     */
    public int getNoOfColumn(){
        return rows.get(0).size()
    }

    /**
     * Returns the number of the column of the said row number passed
     * @param rowNo - row number for which the number columns needs to be returned.
     * @return
     */
    public int getNoOfColumn(int rowNo){
        return rows.get(rowNo).size()
    }
}
