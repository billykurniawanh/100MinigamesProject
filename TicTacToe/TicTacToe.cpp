#include <iostream>
#include <iomanip>
#include <cmath>
#include <fstream>

using namespace std;

void displayboard(string array[3][3]){
   for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
         cout << array[i][j] << " ";
      }
      cout << endl;
   }
}

bool gameEnd(string array[3][3]){
   string check = "";
   bool result = false;
   bool status;
   
   for (int i = 0; i < 3; i++){
      check = array[i][0];
      if (check != "-"){
         status = true;
         for (int j = 0; j < 3; j++){
           if (array[i][j] != check)
               status = false; 
         }
         if (status){
            if (check == "O")
               cout << "Player 1 Wins!";
            else
               cout << "Player 2 Wins!";
            return true;
         }
      }
   }
   
   for (int i = 0; i < 3; i++){
      check = array[0][i];
      if (check != "-"){
         status = true;
         for (int j = 0; j < 3; j++){
           if (array[j][i] != check)
               status = false; 
         }
         if (status){
            if (check == "O")
               cout << "Player 1 Wins!";
            else
               cout << "Player 2 Wins!";
            return true;
         }
      }
   }
   
   check = array[0][0];
   if (check != "-"){
      status = true;
      for (int i = 0; i < 3; i++){
         if (array[i][i] != check)
            status = false;
      }
      if (status){
         if (check == "O")
            cout << "Player 1 Wins!";
         else
            cout << "Player 2 Wins!";
         return true;
      }
   }
   
   check = array[2][2];
   if (check != "-"){
      status = true;
      for (int i = 2; i >= 0; i--){
         if (array[i][i] != check)
            status = false;
      }
      if (status){
         if (check == "O")
            cout << "Player 1 Wins!";
         else
            cout << "Player 2 Wins!";
         return true;
      }
   }
   
   result = true;
   for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
         if (array[i][j] == "-")
            result = false;
      }
   }
   
   if (result)
      cout << "Draw!";
   
   return result;
}
       

   
    
int main(){
   string array[3][3];
   bool status = false;
   for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
         array[i][j] = "-";
      }
   }
   
   int row;
   int column;
   while (!status){
      cout << "Player 1 -> Enter row and column (1-3): ";
      cin >> row >> column;
      while (array[row-1][column-1] == "O" || array[row-1][column-1] == "X"){
         cout << "Error! Enter another spot: ";
         cin >> row >> column;
      }
      array[row-1][column-1] = "O";
      displayboard(array);
      cout << endl;
      status = gameEnd(array);
      if (status)
         break;
      cout << "Player 2 -> Enter row and column (1-3): ";
      cin >> row >> column;
      while (array[row-1][column-1] == "O" || array[row-1][column-1] == "X"){
         cout << "Error! Enter another spot: ";
         cin >> row >> column;
      }
      array[row-1][column-1] = "X";
      displayboard(array);
      cout << endl;
      status = gameEnd(array);
   }
      
}