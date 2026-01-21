# define a simple plot function to plot input size vs time graph
def plot_graph(input_sizes, time):
    import matplotlib.pyplot as plt

    plt.plot(input_sizes, time, marker='o')
    plt.title('Full Compute Input Size vs Time for FullKnapSack Algorithm (Log Scale)')
    plt.xlabel('Input Size (number of items)')
    plt.ylabel('Time (seconds)')

    plt.yscale('log')
    plt.grid(True)
    
    plt.savefig('full_compute_log_scale_input_size_vs_time_graph.png')
    plt.show()

# create for loop to iterate through the 30 output files and average the time for each input size
time = []
input_sizes = list(range(1, 26))
for i in range(1, 26): # iterate through input of item sizes 1 to 25
    total_time = 0.0
    for j in range(1, 31): # iterate through 30 output files 
        with open(f'data/bash_outputs/bash_output_sample_number_{j}.txt', 'r') as f:
            lines = f.readlines()
            total_time += float(lines[i - 1].strip())
    average_time = total_time / 30 # get mean by dividing total time by 30
    time.append(average_time)

# plot the graph
plot_graph(input_sizes, time)

