import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  
 
def f_1(x, A, B):  
    return A*x + B  
  

def f_2(x, A, B, C):  
    return A*x*x + B*x + C  
  

def f_3(x, A, B, C, D):  
    return A*x*x*x + B*x*x + C*x + D  
  
def plot_test():  
  

  
  
    x01 = [8, 32, 128, 512, 1024, 4096, 8192]  
    y01 = [1, 2, 5, 10, 14, 34, 63]  
    
    x02 = [8, 32, 128, 512, 1024, 4096, 8192]  
    y02 = [1, 1, 2, 6, 11, 27, 44]
    
    x03 = [8, 32, 128, 512, 1024, 4096, 8192]  
    y03 = [0, 1, 2, 5, 10, 24, 37]
    
  
 
    plt.scatter(x01[:], y01[:], 25, "blue")  
    plt.scatter(x02[:], y02[:], 25, "red")
    plt.scatter(x03[:], y03[:], 25, "green")

    
 
    A1, B1, C1, D1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 8200, 0.01)  
    y1 = A1*x1*x1*x1 + B1*x1*x1 + C1*x1 + D1 
    plt.plot(x1, y1, "blue", label="QuickFind")  
  

    A2, B2, C2, D2= optimize.curve_fit(f_3, x02, y02)[0]  
    x2 = np.arange(0, 8200, 0.01)  
    y2 = A2*x2*x2*x2 + B2*x2*x2 + C2*x2 + D2  
    plt.plot(x2, y2, "red", label="QuickUnion")  
    
    A3, B3, C3, D3= optimize.curve_fit(f_3, x03, y03)[0]  
    x3 = np.arange(0, 8200, 0.01)  
    y3 = A3*x3*x3*x3 + B3*x3*x3 + C3*x3 + D3  
    plt.plot(x3, y3, "green", label="WeightedQuickUnion")  
    
    plt.legend(loc='upper left')
  
    plt.title("UnionFind")  
    plt.xlabel('int')  
    plt.ylabel('ms')  
  
    plt.show()  
  
    return  

plot_test()