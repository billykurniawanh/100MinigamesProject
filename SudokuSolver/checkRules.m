function [valid] = checkRules(puzzle)
valid = true;
for i = 1:9
    for j = 1:9
        for k = 1:9
            %check the row
            if puzzle(i,j) == puzzle(i,k) && j~=k && puzzle(i,j)~=0
                valid = false;
             %check the collumn
            elseif puzzle(i,j) == puzzle(k,j) && i~=k && puzzle(i,j)~=0
                valid = false;
            end
        end
       
        %check the square
        if 1<=i && i<=3 && 1<=j && j<=3
            for m = 1:3
                for n = 1:3
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 1<=i && i<=3 && 4<=j && j<=6
            for m = 1:3
                for n = 4:6
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 1<=i && i<=3 && 7<=j && j<=9
            for m = 1:3
                for n = 7:9
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 4<=i && i<=6 && 1<=j && j<=3
            for m = 4:6
                for n = 1:3
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 4<=i && i<=6 && 4<=j && j<=6
            for m = 4:6
                for n = 4:6
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 4<=i && i<=6 && 7<=j && j<=9
            for m = 4:6
                for n = 7:9
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 7<=i && i<=9 && 1<=j && j<=3
            for m = 7:9
                for n = 1:3
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 7<=i && i<=9 && 4<=j && j<=6
            for m = 7:9
                for n = 4:6
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        elseif 7<=i && i<=9 && 7<=j && j<=9
            for m = 7:9
                for n = 7:9
                    if puzzle(i,j) == puzzle(m,n) && i~=m && j~=n && puzzle(i,j)~=0
                        valid = false;
                    end
                end
            end
        end
    end
end
        
        
        
