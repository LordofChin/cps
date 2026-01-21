
weight=15
size=20
iterations=20

# outer loop to generate redundant trials to get an average
rm -rf data/bash_outputs
rm -rf data/bash_inputs
mkdir -p data/bash_outputs
mkdir -p data/bash_inputs
for h in {1..30}
do
    mkdir -p data/bash_inputs/bash_input_sample_number_$h

    # loop to generate knapsack input files for knapsack problem
    for i in {1..25}
    do
    #generate a input.txt file with i items store it as bashInput.txt

        #generate input file header in format weight size number_of_items
        echo "$weight $size $i" > data/bash_inputs/bash_input_sample_number_$h/bash_input_at_items_count_of_$i.txt

        #generate i items with random weight size and values between 1 and 10
        for j in $(seq 1 $i)
        do
            # RANDOM % (max - min + 1) + min -OR- RANDOM % (10 - 1 + 1) + 1
            #iterate letter of the alphabet for item name
            item_name_val=$((65 + j - 1 )) #ASCII value of A is 65
            item_name=$(printf "\\$(printf '%03o' $item_name_val)")
            item_weight=$((RANDOM % (10 - 1 + 1) + 1))
            item_size=$((RANDOM % (10 - 1 + 1) + 1))
            item_value=$((RANDOM % (10 - 1 + 1) + 1))
            echo "$item_name $item_weight $item_size $item_value" >> data/bash_inputs/bash_input_sample_number_$h/bash_input_at_items_count_of_$i.txt
        done
    done

    # process randomly generated knapsack input files and store running times in output file
    rm -rf data/bash_outputs/bash_output_sample_number_$h.txt
    for i in {1..25}
    do
        # run FullKnapSack algorithm and extract running time with simple pipes to popular unix-command, grep (global regex print). 
        # Append results to output file.
        # use -o to return only the specified regex and -E for extended regex (to include decimal point) - This part was googled because I forgor the syntax
        java -Xmx8g FullKnapSack4Bash.java data/bash_inputs/bash_input_sample_number_$h/bash_input_at_items_count_of_$i.txt | grep "Total running time:" | grep -oE "[0-9.]+" >> data/bash_outputs/bash_output_sample_number_$h.txt
    done

done

# run graph.py 
    # didn't work locally for me initially - python3 in PATH didn't have matplotlib installed, 
    # but VSCode's internal python did. - Ran manually with VSCode's python interpreter (python on macOS sucks)
python3 -m pip install matplotlib # added after for consistent performance on different systems
python3 graph.py
