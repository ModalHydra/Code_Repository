//
//  main.cpp
//  ML_From_Scratch
//
//  Created by Gabriel Bentley on 9/23/22.
//


#include <stdio.h>
#include<iostream>
#include<string>
#include<fstream>
#include<vector>
#include<chrono>

using namespace std;

// the number of values in the data set
const int MAX_VALUE = 1046;

// a class to hold the data values being read from the csv file
class data_field {
    public:
    vector<double> X;
    vector<double> survived;
    vector<double> pclass;
    vector<double> sex;
    vector<double> age;
    int num_instances;

};
    
// a matrix class to act as a matrix and vector for calculations
class Matrix {
    private:
        int rows = 1;
        int columns = 1;
        vector<double> matrix_values;
    
    public:
        Matrix(int x,int y): rows(x), columns(y), matrix_values(rows * columns)
        {
            
        }
        
        void setValue(int x, int y, double value){
            matrix_values[x * columns + y] = value;
        }
        
        double getValue(int x, int y){
            
            return matrix_values[x * columns + y];
        }
        
        int getRows(){
            return rows;
        }
        
        int getColumns(){
            return columns;
        }
        
        int getSize(){
            return rows * columns;
        }
    
    // a function that takes in a vector and fills the matrix if if vector hold the same number of elements as the matrix
    void fillMatrix(vector<double> x){
        if(x.size() == rows * columns){
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    matrix_values[i * columns + j] = x[i * columns + j];
                }
            }
        }
    }
    
    // prints the rows in the matrix
    void printMatrix(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                cout << matrix_values[i * columns + j] << " ";
            }
            cout << endl;
            //cout << "row " << i << endl;
        }
    }
    
    // prints all values in the matrix one by one
    void printMatrixValues(){
        for(int i = 0; i < columns * rows; i++){
            cout << matrix_values[i] << " ";
        }
    }
    
    // returns a single column as a vector
    vector<double> getColumnVector(int col){
        vector<double> col_vector;
        
        col_vector.resize(rows);
        
        for(int i = 0; i < rows; i++){
            col_vector[i] = matrix_values[i * columns + col];
        }
        
        return col_vector;
    }
    
    // returns a single row as a vector
    vector<double> getRowVector(int row){
        vector<double> row_vector;
        
        row_vector.resize(columns);
        
        for(int i = 0; i < rows; i++){
            row_vector[i] = matrix_values[row * columns + i];
        }
        
        return row_vector;
    }
    
    // takes a vector and makes the matrix column equal that vector
    void setColumnVector(vector<double> vec, int col){
        for(int i = 0; i < rows; i++){
            matrix_values[i * columns + col] = vec[i];
        }
    }
    
    // takes a vector and makes the matrix row equal that vector
    void setRowVector(vector<double> vec, int row){
        for(int i = 0; i < columns; i++){
            matrix_values[row * columns + i] = vec[i];
        }
    }
    
    // takes an integer and fills the matrix column with that integer
    void setColumnVector(int num, int col){
        for(int i = 0; i < rows; i++){
            matrix_values[i * columns + col] = num;
        }
    }
    
};

Matrix m_multiplication(Matrix A, Matrix B);
Matrix m_multiplication(Matrix A, double num);
Matrix m_addition(Matrix A, Matrix B);
Matrix m_subtraction(Matrix A, Matrix B);
Matrix t_matrix(Matrix A);
void LG_Regression(data_field train, data_field test);
void naive_Bayes(data_field train, data_field test);
data_field train_df(data_field df, int numRows);
data_field test_df(data_field df, int numRows);
Matrix sigmoid(Matrix A);
Matrix log_likelyhood(Matrix A, Matrix B);
Matrix probabilities(Matrix A);
Matrix predictions(Matrix A);
double accuracy(Matrix A, Matrix B);
double find_true_positive(Matrix A, Matrix B);
double find_true_negative(Matrix A, Matrix B);
double sensitivity(double tp, double fn);
double specificity(double tn, double fp);
double get_age_mean_by_class(Matrix train, int survived);
double get_age_var_by_class(Matrix train, int survived, double mean);
double cal_age_lh(double age, double age_mean, double age_var);
Matrix cal_raw_prob(double pclass, double sex, double age, Matrix apriori, Matrix lh_pclass, Matrix lh_sex, Matrix age_mean, Matrix age_var);

int main(int argc, const char * argv[]) {
    // the code to read from the csv file
    ifstream inFS;
    string line;
    string X_in, survived_in, pclass_in, sex_in, age_in, trash;
    data_field titanic;
    titanic.X.resize(MAX_VALUE);
    titanic.pclass.resize(MAX_VALUE);
    titanic.survived.resize(MAX_VALUE);
    titanic.sex.resize(MAX_VALUE);
    titanic.age.resize(MAX_VALUE);
    
    
    cout << "Openng file titanic_project.csv." << endl;
    
    inFS.open("titanic_project.csv");
    
    // varify that titanci_project.csv has opened
    if(!inFS.is_open()){
        cout << "File failed to open" << endl;
        return 1;
    }
    
    cout << "getting line one" << endl;
    getline(inFS, line);
    
    cout << "heading: " << line << endl;
    
    int numObservations = 0;
    
    // read the entries in the Boston.csv file and add them to vectors
    while(inFS.good()){
        inFS.get();
        getline(inFS, X_in, '"');
        inFS.get();
        getline(inFS, pclass_in, ',');
        getline(inFS, survived_in, ',');
        getline(inFS, sex_in, ',');
        getline(inFS, age_in, '\n');
        
        titanic.X.at(numObservations) = stof(X_in);
        titanic.pclass.at(numObservations) = stof(pclass_in);
        titanic.survived.at(numObservations) = stof(survived_in);
        titanic.sex.at(numObservations) = stof(sex_in);
        titanic.age.at(numObservations) = stof(age_in);

        numObservations++;
    }
    
    titanic.X.resize(numObservations);
    titanic.pclass.resize(numObservations);
    titanic.survived.resize(numObservations);
    titanic.sex.resize(numObservations);
    titanic.age.resize(numObservations);

    
    titanic.num_instances = int(titanic.X.size());
    cout << "New length = " << titanic.num_instances << endl;
    cout << "closing file titanic_project.csv." << endl;
    
    // close the Boston.csv file
    inFS.close();
    
    // seperate into train and test data fields
    data_field train = train_df(titanic, 800);
    data_field test = test_df(titanic, titanic.num_instances - 800);
    
    cout << "Starting Logistic Regression" << endl;
    
    LG_Regression(train, test);
    
    cout << "Ending Logistic Regression" << endl << endl;
    
    cout << "Starting naive Bayes" << endl;
    
    naive_Bayes(train, test);
    
    cout << "Ending naive Bayes" << endl;
    
    return 0;
}

// performs matrix multiplicatoin on two given matrixes
Matrix m_multiplication(Matrix A, Matrix B){
    int A_rows = A.getRows();
    int A_columns = A.getColumns();
    int B_rows = B.getRows();
    int B_columns = B.getColumns();
    Matrix C(A_rows, B_columns);
    double dot_product_sum = 0;
    
    if (A_columns != B_rows){
        cout << "cannot be multiplied" << endl;
        return A;
    }

    for(int i = 0; i < A_rows; i++){
        
        // get all dot products for one row of A
        for(int j = 0; j < B_columns; j++){
            
            // get 1 row column dot product sum
            for(int k = 0; k < A_columns; k++){
                dot_product_sum += A.getValue(i, k) * B.getValue(k, j);
            }
            
            C.setValue(i, j, dot_product_sum);
            dot_product_sum = 0;
        }
    }
      
        
    return C;
}

// returns the transpose of a given matrix
Matrix t_matrix(Matrix A){
    
    Matrix T(A.getColumns(),A.getRows());
    
    for(int i = 0; i < A.getColumns(); i++){
        T.setRowVector(A.getColumnVector(i), i);
    }
    
    return T;
}

// multiplies a matrix by a number
Matrix m_multiplication(Matrix A, double num){
    
    for(int i = 0; i < A.getRows(); i++){
        for(int j = 0; j < A.getColumns(); j++){
         
            A.setValue(i, j, (A.getValue(i, j) * num));
            
        }
    }
    
    return A;
}

// adds two matrixs
Matrix m_addition(Matrix A, Matrix B){
    Matrix C(A.getRows(), A.getColumns());
    
    if(A.getRows() != B.getRows() || A.getColumns() != B.getColumns()){
        cout << "cannot add the matrixes" << endl;
        return A;
    }
    
    for(int i = 0; i < A.getRows(); i++){
        for(int j = 0; j < A.getColumns(); j++){
            C.setValue(i, j, (A.getValue(i, j) + B.getValue(i, j)));
        }
    }
    
    return C;
}

// subtracts two matrixs
Matrix m_subtraction(Matrix A, Matrix B){
    Matrix C(A.getRows(), A.getColumns());
    
    if(A.getRows() != B.getRows() || A.getColumns() != B.getColumns()){
        cout << "cannot add the matrixes" << endl;
        return A;
    }
    
    for(int i = 0; i < A.getRows(); i++){
        for(int j = 0; j < A.getColumns(); j++){
            C.setValue(i, j, (A.getValue(i, j) - B.getValue(i, j)));
        }
    }
    
    return C;
}

void LG_Regression(data_field train, data_field test){
    Matrix weight_sex(2, 1); // 0 is intercept, 1 is sex
    weight_sex.setColumnVector(1, 0);
    

    // a matrix with only one column acting as a vector to hold the survived column of train data field
    Matrix labels(train.num_instances, 1);
    
    labels.setColumnVector(train.survived, 0);
    
    Matrix data_matrix_sex(train.num_instances, 2);
    
    data_matrix_sex.setColumnVector(1, 0);
    data_matrix_sex.setColumnVector(train.sex, 1);

    
    
    cout << endl;
    
    Matrix error_sex(train.num_instances, 1);
    Matrix prob_vector_sex(train.num_instances, 1);
 
    
    //m_multiplication(data_matrix_sex, weight_sex).printMatrix();

    
    double learn_rate = 0.001;

    
    auto start = std::chrono::system_clock::now();

    // train the logistical regression model
    for(int i = 0; i < 10000; i++){
        prob_vector_sex = sigmoid(m_multiplication(data_matrix_sex, weight_sex));
        error_sex = m_subtraction(labels, prob_vector_sex);
        weight_sex = m_addition(weight_sex, m_multiplication(m_multiplication(t_matrix(data_matrix_sex), error_sex), learn_rate));
    }
    
    auto end = std::chrono::system_clock::now();

    auto elapsed =
        std::chrono::duration_cast<std::chrono::milliseconds>(end - start);
    
    
    cout << "Here is the coeficient for only using sex as a predictor" << endl;
    weight_sex.printMatrix();
    cout << endl;
 
    
    // starting preditions on test data
    
    Matrix test_matrix_sex(test.num_instances, 2);
    test_matrix_sex.setColumnVector(1, 0);
    test_matrix_sex.setColumnVector(test.sex, 1);
    
    // the matrix vector holding the actual survived of the test data field
    Matrix test_labels(test.num_instances,1);
    test_labels.setColumnVector(test.survived, 0);
    
    Matrix predicted_sex = m_multiplication(test_matrix_sex, weight_sex);
    Matrix probabilitiy_sex = probabilities(predicted_sex);
    Matrix predictions_sex = predictions(probabilitiy_sex);
    double accuracy_sex = accuracy(predictions_sex, test_labels);
    
    cout << "the accuracy is : " << accuracy_sex << endl;
    
    // find the number of predicted deaths
    double pred_Num_false = 0;
    for(int i = 0; i < predictions_sex.getRows(); i++){
        if(predictions_sex.getValue(i, 0) == 0){
            pred_Num_false++;
        }
    }
    // find the number of predicted survivors
    double pred_num_true = predictions_sex.getRows() - pred_Num_false;
    
    double tp = find_true_positive(predictions_sex, test_labels);
    double tn = find_true_negative(predictions_sex, test_labels);
    double fp = pred_num_true - tp;
    double fn = pred_Num_false - tn;
    
    cout << "true postive is " << tp << endl;
    cout << "true negative is " << tn << endl;
    cout << "false postive is " << fp << endl;
    cout << "false negative is " << fn << endl;
    
    double sens = sensitivity(tp, fn);
    double specif = specificity(tn, fp);
    
    cout << "The sensitivity is " << sens << endl;
    cout << "The specificity is " << specif << endl;
    cout << "The time taken for the algorithm is " << elapsed.count() << " Milliseconds" << endl;
    
    
}

// takes in a matrix z and returns the vector of sigmond values for the matrix
Matrix sigmoid(Matrix A){
    
    const double e = 2.71828182845904;
    vector<double> sig_values;
    sig_values.resize(A.getRows());
    Matrix C(A.getRows(),1);
    for(int i =0; i < A.getRows(); i++){
        double tempValue = 1/(1+pow(e, (A.getValue(i, 0) * -1)));
        sig_values.at(i) = tempValue;
    }
    
    C.setColumnVector(sig_values, 0);
    
    
    return C;
}

// takes in a matrix and returns the probabilities of that matrix
Matrix probabilities(Matrix A){
    const double e = 2.71828182845904;
    Matrix P(A.getRows(), 1);
    double temp_value = 0;
    for(int i = 0; i < A.getRows(); i++){
        temp_value = pow(e, A.getValue(i, 0))/(1 + A.getValue(i, 0));
        P.setValue(i, 0, temp_value);
    }
    
    return P;
}

// takes in a matrix and compare the probabilities for if they are less than or greater than 0.5
Matrix predictions(Matrix A){
    
    Matrix P(A.getRows(), 1);
    
    for(int i = 0; i < A.getRows(); i++){
        if(A.getValue(i, 0) > 0.5){
            P.setValue(i, 0, 1);
        }
        else{
            P.setValue(i, 0, 0);
        }
    }
    
    return P;
}

// gets teh accuracy of prediction matrix agains the test matrix
double accuracy(Matrix pred, Matrix test){
    
    double mean;
    double num_right = 0;
    
    for(int i = 0; i < pred.getRows(); i++){
        if(pred.getValue(i, 0) == test.getValue(i, 0)){
            num_right++;
        }
    }
    
    mean = num_right/pred.getRows();
    
    return mean;
}

// fills the train data field
data_field train_df(data_field df, int numRows){
    
    data_field train;
    
    train.X.resize(numRows);
    train.pclass.resize(numRows);
    train.survived.resize(numRows);
    train.sex.resize(numRows);
    train.age.resize(numRows);
    train.num_instances = numRows;
    
    for(int i = 0; i < numRows; i++){
        train.X.at(i) = df.X.at(i);
        train.age.at(i) = df.age.at(i);
        train.pclass.at(i) = df.pclass.at(i);
        train.sex.at(i) = df.sex.at(i);
        train.survived.at(i) = df.survived.at(i);
    }
    
    
    return train;
}

// fills the test data field
data_field test_df(data_field df, int numRows){
    
    data_field test;
    int num_instances = df.num_instances;
    int count =0;
    
    test.X.resize(numRows);
    test.pclass.resize(numRows);
    test.survived.resize(numRows);
    test.sex.resize(numRows);
    test.age.resize(numRows);
    test.num_instances = numRows;
    
    for(int i = num_instances-numRows; i < num_instances; i++){
        test.X[count] = df.X[i];
        test.age[count] = df.age[i];
        test.pclass[count] = df.pclass[i];
        test.sex[count] = df.sex[i];
        test.survived[count] = df.survived[i];
        
        count++;
    }
    
    return test;
}

// finds the tp for the model
double find_true_positive(Matrix A, Matrix B){
    double tp = 0;
    
    for(int i = 0; i < A.getRows(); i++){
        if(A.getValue(i, 0) == B.getValue(i, 0) && A.getValue(i, 0) == 1){
            tp++;
        }
    }
    
    return tp;
}

// finds the tn for the model
double find_true_negative(Matrix A, Matrix B){
    double tn = 0;
    
    for(int i = 0; i < A.getRows(); i++){
        if(A.getValue(i, 0) == B.getValue(i, 0) && A.getValue(i, 0) == 0){
            tn++;
        }
    }
    
    return tn;
}

double sensitivity(double tp, double fn){
    
    return tp/(tp+fn);
}

double specificity(double tn, double fp){
    
    return tn/(tn+fp);
}


void naive_Bayes(data_field train, data_field test){
    
    // find the prior probability using the training set
    Matrix data_train(train.num_instances, 4);
    Matrix data_test(test.num_instances, 4);
    
    data_train.setColumnVector(train.survived, 0);
    data_train.setColumnVector(train.pclass, 1);
    data_train.setColumnVector(train.sex, 2);
    data_train.setColumnVector(train.age, 3);
    data_test.setColumnVector(test.survived, 0);
    data_test.setColumnVector(test.pclass, 1);
    data_test.setColumnVector(test.sex, 2);
    data_test.setColumnVector(test.age, 3);
    
    auto start = std::chrono::system_clock::now();

    
    // get the number of people who lived and died in the train data set
    Matrix apriori(2,1);
    Matrix count_survived(2,1);
    double num_survived = 0;
    double num_perished = 0;
    for(int i = 0; i < data_train.getRows(); i++){
        if(data_train.getValue(i, 0) == 1){
            num_survived++;
        }
        if(data_train.getValue(i, 0) == 0){
            num_perished++;
        }
    }
    
    // fill the matrixs with the results
    apriori.setValue(1, 0, num_survived/data_train.getRows());
    apriori.setValue(0, 0, num_perished/data_train.getRows());
    count_survived.setValue(1, 0, num_survived);
    count_survived.setValue(0, 0, num_perished);
    
    
    cout << "Here are the apriori values:" << endl;
    cout << "num survived is : " << num_survived << endl;
    cout << "num perished is : " << num_perished << endl;
    apriori.printMatrix();
    
    Matrix lh_pclass(2, 3);
    
    // find the likelihood of pclass
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 3; j++){
            double value = 0;
            double num_rows = 0;
            
            for(int k = 0; k < data_train.getRows(); k++){
                if(data_train.getValue(k, 1) == j+1 && data_train.getValue(k, 0) == i){
                    num_rows++;
                }
            }
            
            value = num_rows/count_survived.getValue(i, 0);
            
            lh_pclass.setValue(i, j, value);
        }
    }
    
    cout << "Here are the likelyhood values for pclass" << endl;
    
    lh_pclass.printMatrix();
    
    // find the likelihood of sex
    
    Matrix lh_sex(2,2);
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            double value = 0;
            double num_rows = 0;
            
            for(int k = 0; k < data_train.getRows(); k++){
                if(data_train.getValue(k, 2) == j && data_train.getValue(k, 0) == i){
                    num_rows++;
                }
            }
            
            value = num_rows/count_survived.getValue(i, 0);
            
            lh_sex.setValue(i, j, value);
        }
    }
    
    cout << "Here are the likelyhood values for sex" << endl;
    
    lh_sex.printMatrix();
    
    
    // get mean of age for survived and perished
    // get variance of age for survived and perished
    Matrix age_mean(2, 1);
    Matrix age_var(2, 1);
    
    for(int i = 0; i < 2; i++){
        age_mean.setValue(i, 0, get_age_mean_by_class(data_train, i));
        age_var.setValue(i, 0, get_age_var_by_class(data_train, i, age_mean.getValue(i, 0)));
    }
        
    // get matrix of probabilites and fill it
    
    Matrix probability(data_test.getRows(), 1);
    
    for(int i = 0; i < data_test.getRows(); i++){
        Matrix raw = cal_raw_prob(data_test.getValue(i, 1), data_test.getValue(i,2), data_test.getValue(i, 3), apriori, lh_pclass, lh_sex, age_mean, age_var);
        
        probability.setValue(i, 0, raw.getValue(1, 0));
    }
    
    // call the prediction function on the matrix of probabilities
    Matrix pred = predictions(probability);
    
    auto end = std::chrono::system_clock::now();

    auto elapsed =
        std::chrono::duration_cast<std::chrono::milliseconds>(end - start);

    
    Matrix test_labels(data_test.getRows(), 1);
    
    test_labels.setColumnVector(data_test.getColumnVector(0), 0);
    
    double acc = accuracy(pred, test_labels);
    
    cout << "the accuracy is : " << acc << endl;
    
    double pred_Num_false = 0;
    for(int i = 0; i < pred.getRows(); i++){
        if(pred.getValue(i, 0) == 0){
            pred_Num_false++;
        }
    }
    double pred_num_true = pred.getRows() - pred_Num_false;
    
    double tp = find_true_positive(pred, test_labels);
    double tn = find_true_negative(pred, test_labels);
    double fp = pred_num_true - tp;
    double fn = pred_Num_false - tn;
    
    cout << "true postive is " << tp << endl;
    cout << "true negative is " << tn << endl;
    cout << "false postive is " << fp << endl;
    cout << "false negative is " << fn << endl;
    
    double sens = sensitivity(tp, fn);
    double specif = specificity(tn, fp);
    
    cout << "The sensitivity is " << sens << endl;
    cout << "The specificity is " << specif << endl;
    cout << "The time taken for the algorithm is " << elapsed.count() << " Milliseconds" << endl;
    
}

// get the mean of age for a given class
double get_age_mean_by_class(Matrix train, int survived){
    
    double sum = 0;
    double count = 0;
    
    for(int i = 0; i < train.getRows(); i++){
        if(train.getValue(i, 0) == survived){
            sum+= train.getValue(i, 3);
            count++;
        }
    }
    
    return sum/count;
}

// get variance of age for a given class
double get_age_var_by_class(Matrix train, int survived, double mean){
    
    double sum = 0;
    double count = 0;
    double temp;
    
    // var = 1/(n-1)*sum((xi - xmean)^2)
    for(int i = 0; i < train.getRows(); i++){
        temp = train.getValue(i, 0);
        if(temp == survived){
            sum+= pow(temp-mean,2);
            count++;
        }
    }
    
    return (1/(count - 1)) * sum;
}

// calculate the likelihood of age
double cal_age_lh(double age, double age_mean, double age_var){
    double pi = 3.14159;
    double e = 2.71828;
    
    double first = 1/sqrt(2*pi*age_var);
    double second = pow(e, -(pow(age-age_mean, 2)/(2*age_var)));
    
    return first * second;
}

// find the raw probabilies for the model
Matrix cal_raw_prob(double pclass, double sex, double age, Matrix apriori, Matrix lh_pclass, Matrix lh_sex, Matrix age_mean, Matrix age_var){
    
    Matrix raw(2,1);
    double num_s;
    double num_p;
    double denominator;
    
    num_s = lh_pclass.getValue(1, pclass - 1) * lh_sex.getValue(1, sex) * apriori.getValue(1, 0)*cal_age_lh(age, age_mean.getValue(1, 0), age_var.getValue(1, 0));
    
    num_p = lh_pclass.getValue(0, pclass - 1) * lh_sex.getValue(0, sex) * apriori.getValue(0, 0)*cal_age_lh(age, age_mean.getValue(0, 0), age_var.getValue(0, 0));
    
    denominator = num_s + num_p;
    
    raw.setValue(1, 0, num_s/denominator);
    raw.setValue(0, 0, num_p/denominator);
    
    
    return raw;
}
