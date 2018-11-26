import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  

def f_1(x, A, B):  
    return A*x + B  

def f_2(x, A, B, C):  
    return A*x*x + B*x + C  
  
def f_3(x, A, B):  
    return A*np.log2(x) + B  
  
def plot_test():  
  


    x01 = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384]  
    y01 = [0
,0.31
,0.638333
,1.286869
,1.960048
,2.785067
,3.721565
,4.68982
,5.658734
,6.675271
,7.696864
,8.741088
,9.809582
,10.8267
,11.84398
]  

    x02 = [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384]  
    y02 = [0
,0.5
,1
,1.625
,2.375
,3.21875
,4.125
,5.070313
,6.039063
,7.021484
,8.011719
,9.006348
,10.00342
,11.00183
,12.00098
]
    
  
    plt.scatter(x01[:], y01[:], 25, "blue")  
    plt.scatter(x02[:], y02[:], 25, "red")

    
    A1, B1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 17000, 0.01)  
    y1 = A1*np.log2(x1) + B1  
    plt.plot(x1, y1, "blue", label="random")  
  
    A2, B2= optimize.curve_fit(f_3, x02, y02)[0]  
    x2 = np.arange(0, 17000, 0.01)  
    y2 = A2*np.log2(x1) + B2  
    plt.plot(x2, y2, "red", label="sorted") 
    
    plt.legend(loc='upper left')
  
    plt.title("RedBlackTree")  
    plt.xlabel('size')  
    plt.ylabel('path length')  
  
    plt.show()  
    print("Random: y="+str(A1)+"log(x)+("+str(B1)+")")
    print("Sorted: y="+str(A2)+"log(x)+("+str(B2)+")")
  
    return  

plot_test()