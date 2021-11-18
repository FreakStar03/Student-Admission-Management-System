#include <iostream>
using namespace std;

class Vehicle
{
    public:  
    void display()
    {
       cout << "This is a Vehicle" << endl;
    }
};

class Car: public Vehicle
{
    public:  
    void display()
    {
       cout << "This is a Car" << endl;
    }
};

class Bike: public Vehicle
{
    public:  
    void display()
    {
       cout << "This is a Bike" << endl;
    }
};

int main(void) {  
    int N = 2;
    if(N == 4){
        Car d = Car();    
        d.display(); 
    } else if(N == 2){
        Bike d = Bike();    
        d.display();         
    }
    else{
    Vehicle d = Vehicle();    
    d.display();
    }
   return 0;  
}  