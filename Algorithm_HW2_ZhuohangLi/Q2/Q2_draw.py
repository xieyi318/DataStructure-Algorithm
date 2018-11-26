import numpy as np  
import matplotlib.pyplot as plt  
from scipy import optimize  
  
 
def f_3(x, A, B, C, D):  
    return A*x*x*x + B*x*x + C*x + D  
  
def plot_test():  
  

    x01 = [1024, 2048, 4096, 8192, 16384, 32768]  
    y01 = [3, 3, 2, 3, 4, 11]  
    

    plt.scatter(x01[:], y01[:], 25, "blue")  


    A1, B1, C1, D1= optimize.curve_fit(f_3, x01, y01)[0]  
    x1 = np.arange(0, 32768, 0.01)  
    y1 = A1*x1*x1*x1 + B1*x1*x1 + C1*x1 + D1 
    plt.plot(x1, y1, "blue", label="naive")  
  
    
  
    plt.title("Kendall Tau distance")  
    plt.xlabel('DataSet')  
    plt.ylabel('Runtime(ms)')  
  
    plt.show()  
  
    return  

plot_test()