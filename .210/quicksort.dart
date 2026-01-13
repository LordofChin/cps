import 'dart:math';

void main()
{
	var random = Random();
	List<int> rand_arr = [10];

	for (int i = 0; i < 10; i ++) 
	{
		rand_arr.add(random.nextInt(10));
	}

	quicksort(rand_arr, 0, rand_arr.length - 1);
	print_arr(rand_arr);
	
}

int partition(List<int> arr, int left, int right)
{
	int boundary = arr[(left + right) >> 1];
	left--; right++;
	
	while (true)
	{
		do 
		{
			left++;
		}
		while (arr[left] < boundary);
	
		do 
		{
			right--;
		}
		while(arr[right] > boundary);
	
		if(left >= right) 
		{
			return right;
		}
	
		swap(arr, left, right);
	}
	return 0;
}

void quicksort(List<int> arr, int left, int right)
{
	if (left < right) 
	{
		int b = partition(arr, left, right);
		
		quicksort(arr, left, b);
		quicksort(arr, b + 1, right);
	}
} 

void swap(List<int> arr, int left, int right)
{
	int temp = arr[left];
	arr[left] = arr[right];
	arr[right] = temp;
}


void print_arr(List<int> arr) 
{
	for(int i = 0; i < arr.length; i++)
		print(arr[i]);
}

