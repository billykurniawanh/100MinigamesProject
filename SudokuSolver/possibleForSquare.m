function [possibilities] = possibleForSquare(puzzle, index1, index2)
if puzzle(index1,index2) ~= 0
    possibilities = [puzzle(index1,index2)];
else
    array = 1:9;
    for i = 1:9
        %check the row
        if puzzle(index1,i) ~= 0
            for l = 1:9
                if(array(l) == puzzle(index1,i))
                    array(l) = 0;
                end
                
            end
        end
        %check the collumn
        if puzzle(i,index2) ~= 0
            for l = 1:9
                if(array(l) == puzzle(i,index2))
                    array(l) = 0;
                end
            end
            
        end
    end
    
    %check the square
    if 1<=index1 && index1<=3 && 1<=index2 && index2<=3
        for m = 1:3
            for n = 1:3
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 1<=index1 && index1<=3 && 4<=index2 && index2<=6
        for m = 1:3
            for n = 4:6
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 1<=index1 && index1<=3 && 7<=index2 && index2<=9
        for m = 1:3
            for n = 7:9
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 4<=index1 && index1<=6 && 1<=index2 && index2<=3
        for m = 4:6
            for n = 1:3
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 4<=index1 && index1<=6 && 4<=index2 && index2<=6
        for m = 4:6
            for n = 4:6
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 4<=index1 && index1<=6 && 7<=index2 && index2<=9
        for m = 4:6
            for n = 7:9
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 7<=index1 && index1<=9 && 1<=index2 && index2<=3
        for m = 7:9
            for n = 1:3
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 7<=index1 && index1<=9 && 4<=index2 && index2<=6
        for m = 7:9
            for n = 4:6
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    elseif 7<=index1 && index1<=9 && 7<=index2 && index2<=9
        for m = 7:9
            for n = 7:9
                if puzzle(m,n) ~= 0
                    for l = 1:9
                        if(array(l) == puzzle(m,n))
                            array(l) = 0;
                        end
                    end
                end
            end
        end
    end
    temp = [];
    count = 1;
    for j = 1:length(array)
        if array(j)~=0
            temp(count) = array(j);
            count = count + 1;
        end
    end
    possibilities = temp;
end


