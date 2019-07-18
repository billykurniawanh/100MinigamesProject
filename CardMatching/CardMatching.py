from __future__ import print_function

import random

N=4

class ConcentrationCard:
    def __init__(self,face=" ", show=False):
        self.face = face
        self.show = show
    def __str__(self):
        if self.face=="":
            return "     "
        
        if self.show:
            return "[ " + self.face + " ]"
        else:
            return "[[*]]"
        
    def __eq__(self, card):
        return self.face==card.face

    def __repr__(self):
        return self.__str__()    

def aRow(n):
    return [ConcentrationCard() for i in range(n)]    

def initializeGrid(grid, show=False):
    faces= [chr(i+65) for i in range(1,N**2//2+1)]
    faces = 2 * faces
    random.shuffle(faces)
    
    for row in grid:
        for card in row:
            letter=faces.pop(0)
            card.face = letter
            card.show=show

def printGrid(grid):
    n=len(grid)
    print("      ", end="")
    for c in range(1,n+1):
        print("{:^6}".format(c),end="")
    print("  <<--- column")
    r=1
    for row in grid:
        print("{:^6}".format(r), end="")
        for card in row:
            print(card,end=" ")
        print("\n")
        r += 1
    print("^^^\nrow\n")

def printStats(tries, matches):
    print("Tries: ",tries,"          Matches: ",matches)

def getCard(grid, r, c):
    return grid[r-1][c-1]

def getGuess(grid,prompt):
    n=len(grid)
    while True:
        r,c = eval('input(prompt)')
        if 0<r<=n and 0 < c <= n:
            card = getCard(grid,r,c)
            if card.face !="" and card.show==False:
                break
            else:
                print("You must pick a face down card.  Please try again")
        else:
            print("r and c must be between 1 and", n,"Please try again")
    card.show=True
    return card

def playGame():
    matches = 0
    tries = 0
    grid = [ aRow(N) for i in range(N)]
    initializeGrid(grid)
    
    while matches < N**2//2:
        printGrid(grid)
        printStats(tries, matches)
        card1=getGuess(grid, "Enter row, column for position 1: ")
        printGrid(grid)
        printStats(tries, matches)
        card2=getGuess(grid, "Enter row, column for position 2: ")
        tries += 1
        printGrid(grid)
        printStats(tries, matches)
        if card1==card2:
            print("You found a match!")
            card1.face=""
            card2.face=""
            matches+=1
        else:
            print("Not a match :(")
            card1.show=False
            card2.show=False
        input("Type 'ENTER' to continue")
    
    print("You found all the matches!  Game over.")
    
playGame()
