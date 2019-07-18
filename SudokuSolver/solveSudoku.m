function [solution] = solveSudoku(puzzle)
solution = puzzle;
solveable = 1;
if size(solution)==[9 9]
    %check if right size
    [m,n] = size(puzzle);
    if m~=9 || n~=9
        solution = [];
        solveable = 0;
    end
    
    %check if solved
    count = 0;
    for i = 1:9
        row = puzzle(i,:);
        if sum(row) == 45
            count = count+1;
        end
    end
    if count == 9
        solution = puzzle;
        solveable = 0;
    end
    
    %check if valid
    if ~checkRules(puzzle)
        solution = [];
        solveable = 0;
    end
end

if solveable == 1
    if size(solution)==[9 9]
        p = 1;
        q = 1;
        while p<10
            while q<10
                pos = possibleForSquare(solution,p,q);
                if solution(p,q)==0 && isempty(pos)
                    solution = [];
                    p=9;
                    q=9;
                elseif length(pos)==1 && pos(1)~=solution(p,q)
                    solution(p,q) = pos(1)
                    p = 1;
                    q = 0;
                end
                q=q+1;
            end
            p=p+1;
            if p~=10
                q=1;
            end
        end
    end
    
    if size(solution)==[9 9]
        for s=1:9
            for t = 1:9
                o = 9;
                min = 9;
                for u=1:9
                    for v = 1:9
                        if solution(u,v)==0
                            o = length(possibleForSquare(solution,u,v));
                        end
                        if o<min
                            min = o;
                        end
                    end
                end
                if size(solution)==[9 9]
                    chance = possibleForSquare(solution,s,t);
                    if solution(s,t)==0 && length(chance)==min
                        temp1 = solution;
                        if size(temp1)==[9 9]
                            %printPuzzle(solution);
                            for a = 1:min
                                temp1(s,t) = chance(a)
                                temp1 = solveSudoku(temp1)
                                if size(temp1)==[9 9]
                                    solution = temp1;
                                end
                            end
                        end
                    end
                end
            end
        end
    end
end


