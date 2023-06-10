//
//  main.cpp
//  Data_exploration
//
//  Created by Gabriel Bentley on 9/8/22.
//

#include<iostream>
#include<string>
#include<fstream>
#include<vector>

using namespace std;

double cor(vector<double> vec1, vector<double> vec2);
double covar(vector<double> vec1, vector<double> vec2);
double standard_deviation(vector<double> vec);
double vector_sum(vector<double> vec);
double vector_mean(vector<double> vec);
double vector_median(vector<double> vec);
string vector_range(vector<double> vec);
void print_stats(vector<double> vec);



int main(int argc, const char * argv[]) {
    // insert code here...
    ifstream inFS;
    string line;
    string rm_in, medv_in;
    const int MAX_LEN = 1000;
    vector<double> rm(MAX_LEN);
    vector<double> medv(MAX_LEN);
    
    //open the Boston csv file
    cout << "Openng file Boston.csv." << endl;
    
    inFS.open("Boston.csv");
    
    // varify that Boston.csv has opened
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
        getline(inFS, rm_in, ',');
        getline(inFS, medv_in, '\n');
        
        rm.at(numObservations) = stof(rm_in);
        medv.at(numObservations) = stof(medv_in);

        numObservations++;
    }
    
    rm.resize(numObservations);
    medv.resize(numObservations);
    
    cout << "New length = " << rm.size() << endl;
    cout << "closing file Boston.csv." << endl;
    
    // close the Boston.csv file
    inFS.close();
    
    // call print_stats for rm and medv
    cout << "number of records: " << numObservations << endl;
    cout << "\nStats for rm" << endl;
    print_stats(rm);
    
    cout << "\nStats for medv" << endl;
    print_stats(medv);
    
    // find the correlation and covariance between rm and medv
    cout << "\nCorrelation = " << cor(rm, medv) << endl;
    
    cout << "\nCovariance = " << covar(rm, medv)<< endl;
    
    cout << "\nprogram terminated." << endl;
    
    return 0;
}

/* finds the correlation between two vecors
 correlation is the covariance of the vectors divided by the product
 of those vectors standard deviation
*/
double cor(vector<double> vec1, vector<double> vec2){
    
    double var1 = standard_deviation(vec1);
    double var2 = standard_deviation(vec2);
    
    double correlation = covar(vec1, vec2)/(var1 * var2);
    
    return correlation;
}

// Finds the standard deviation of a vector

double standard_deviation(vector<double> vec){
    
    int n = int(vec.size());
    double vec_avg = vector_mean(vec);
    double variance = 0;
    
    // find the sum of the difference between the vector value and the
    // vector average raised to the power of two
    
    for(int i = 0; i < n; i++){
        variance += pow((vec[i] - vec_avg), 2);
    }
    
    // divide the variance by number of elements in the vector - 1
    variance = variance/(n - 1);
    
    // take the square root of the variance to get the standard deviation
    double sd = pow(variance, (0.5));
    
    return sd;
}

// finds the covariance of two vectors

double covar(vector<double> vec1, vector<double> vec2){
    
    int n = int(vec1.size());
    double x_avg = vector_mean(vec1);
    double y_avg = vector_mean(vec2);
    double covariance = 0;
    
    //covariance = sum of ((xi - xavg)(yi - yavg))/(n - 1) for i = 0...n
    
    for(int i = 0; i < n; i++){
        covariance += (vec1[i] - x_avg) * (vec2[i] - y_avg);
    }
    
    covariance = covariance/(n - 1);
    
    return covariance;
}

// gets the sum of all values in a vector

double vector_sum(vector<double> vec){
    
    double sum = 0;
    
    for(int i = 0; i < vec.size(); i++){
        sum += vec[i];
    }
    
    return sum;
}

// gets the average of values in a vector

double vector_mean(vector<double> vec){
    
    return vector_sum(vec)/vec.size();
}

// gets the middle value of a vector

double vector_median(vector<double> vec){
    
    double median;
    unsigned long middle;
    
    sort(vec.begin(), vec.end());
    
    
    if(vec.size() % 2 == 1){
        
        // if vector has an odd number of values get middle value
        
        middle = (vec.size() + 1) / 2;
        
        median = vec[middle - 1];
    }
    else{
        
        // else get the average of the two middle values
        
        middle = vec.size() / 2;
        
        median = (vec[middle -1] + vec[middle]) / 2;
    }
    
    
    
    return median;
}

// get the range of a vector returning a string that holds the
// Min, Max, and difference between min and max

string vector_range(vector<double> vec){
    
    string range;
    
    sort(vec.begin(), vec.end());
    
    range.append("Min: ");
    range.append(to_string(vec[0]));
    range.append(" Max: ");
    range.append(to_string(vec[vec.size() - 1]));
    range.append(" Difference: ");
    range.append(to_string(vec[vec.size() - 1] - vec[0]));
    
    return range;
}

// calls the vector_range, vector_median, vector_mean, and vector_sum
// functions for a vector and prints the results

void print_stats(vector<double> vec){
    
    double median, mean, sum;
    string range;
    range = vector_range(vec);
    median = vector_median(vec);
    mean = vector_mean(vec);
    sum = vector_sum(vec);
    
    cout << "Sum: " << sum << endl;
    cout << "Mean: " << mean << endl;
    cout << "Median: " << median << endl;
    cout << "Range: " << range << endl;
    
}
