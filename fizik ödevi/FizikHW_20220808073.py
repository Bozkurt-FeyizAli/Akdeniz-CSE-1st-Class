import math
import numpy as np
import matplotlib.pyplot as plt
from matplotlib.colors import LinearSegmentedColormap

# Renk skalası tanımlama
# colors = [(0, 'pink'), (0.1, 'yellow'), (0.12, 'orange'),  (0.4, 'blue'), (0.8, 'purple'),  (1, 'purple')]
# custom_cmap = LinearSegmentedColormap.from_list('custom_cmap', colors)

# # Sabitler
# charge_str = input("Enter the charge in nanocoulombs: ")

# # Get the last digit of the charge as a string
# last_digit = charge_str[-1]

# # Convert the last digit to a float
# last_digit_float = float(last_digit)
# Q = last_digit_float * 1e-9
# k = 8.99e9  # N m^2/C^2, Coulomb sabiti
#   # C, yük (pozitif ya da negatif olmasına dikkat edin)

# # # # # 10x10'luk kare alanı oluştur
# x = np.linspace(0, 1, 10)
# y = np.linspace(0, 1, 10)
# X, Y = np.meshgrid(x, y)

# # Elektrik potansiyelini hesapla
# R = np.sqrt(X**2 + Y**2)  # Her noktadan yükün merkezine olan mesafe
# V = k * Q / R

# # Potansiyelin sonsuz ya da tanımsız olduğu yerleri işleme (örneğin, yükün olduğu nokta)
# V[R == 0] = 0

# # Elektrik potansiyeli değerlerini seviyeler olarak al
# V_levels = np.linspace(V.min()/5, V.max()/5, 50)


# # Grafik oluştur
# plt.figure(figsize=(8, 6))

# # Potansiyelin görselleştirilmesi
# plt.contourf(X, Y, V, levels=V_levels, cmap=custom_cmap)

# # Renk skalasının özelleştirilmesi
# plt.colorbar(label='Elektrik Potansiyeli (V)')

# plt.title('Elektrik Potansiyeli Haritası')
# plt.xlabel('x (m)')
# plt.ylabel('y (m)')
# plt.gca().set_aspect('equal', adjustable='box')
# plt.show()


# electric_potential = [[0 for _ in range(10)] for _ in range(10)]
# for i in range(10):
#     for j in range(10):
#         # Calculate the distance from the charge to the point
#         distance = math.sqrt(((i/10)**2 + (j/10)**2))
#         if distance == 0:
#             electric_potential[i][j] = 0
#             continue
#         # Calculate the electric field at the point
#         electric_potential[i][j] = k * Q / distance

# # for row in electric_field:
# #     print(row)
# PlotV1 = [electric_potential[i][0] for i in range(1, 10)]  # Skip electric_field[0][0]

# # Define indices (skipping the first point) and potentials
# indices = list(range(1, 10))
# potentials = PlotV1

# # Create the plot
# plt.figure(figsize=(10, 6))
# plt.plot(indices, potentials, marker='o', linestyle='-', color='b', label='Electric Potential')

# # Label the plot
# plt.title('Electric Potential Plot in the same y but different x points')
# plt.xlabel('Index for x ')
# plt.ylabel('Electric Potential (V)')
# plt.legend()
# plt.grid(True)

# # Show the plot
# plt.show()


# # PlotV2
# diagonal_indices = list(range(1, 10))  # Indices from 1 to 9
# diagonal_potentials = [electric_potential[i][i] for i in range(1, 10)]  # Diagonal potentials excluding the origin

# # Create the plot
# plt.figure(figsize=(10, 6))
# plt.plot(diagonal_indices, diagonal_potentials, marker='o', linestyle='-', color='b', label='Electric Potential')

# # Label the plot
# plt.title('Electric Potential Plot (Diagonal Points)')
# plt.xlabel('Index for x and y')
# plt.ylabel('Electric Potential (V)')
# plt.legend()
# plt.grid(True)

# # Show the plot
# plt.show()

# # f


# # # Define the electric potential function
# grid_size = 10  # Size of the grid (from 0 to 10, inclusive)

# # Generate a grid of coordinates
# x = np.linspace(0, 1, grid_size)
# y = np.linspace(0, 1, grid_size)
# X, Y = np.meshgrid(x, y)

# # Calculate the distance R from the origin (0,0)
# R = np.sqrt(X**2 + Y**2)

# # Initialize the potential array
# V = np.zeros_like(R)

# # Calculate the electric potential V
# for i in range(grid_size):
#     for j in range(grid_size):
#         distance = R[i, j]
#         if distance == 0:
#             V[i, j] = np.nan  # Avoid division by zero
#         else:
#             V[i, j] = k * Q / distance

# # Create a contour plot
# plt.contour(X, Y, V, levels=41, cmap='viridis')  # Adjust the number of levels as needed

# # Add labels and a title
# plt.xlabel('X')
# plt.ylabel('Y')
# plt.title('Equipotential Lines')

# # Add a color bar to show the potential values
# plt.colorbar(label='Electric Potential (V)')

# # Show the plot
# plt.grid(True)
# plt.show()


# v_map = {}

# # Assume V is a 2D list (array) with values
# V = [[i + j for j in range(10)] for i in range(10)]  # Example 2D list initialization, replace with actual data

# # Fill v_map with values from V
# for i in range(10):
#     for j in range(10):
#         key = f"{i}.{j}"
#         v_map[key] = [V[i][j]]

# # Extract the values from v_map to create a 2D array for plotting
# data = np.zeros((10, 10))
# for i in range(10):
#     for j in range(10):
#         key = f"{i}.{j}"
#         data[i, j] = v_map[key][0]

# # Plotting the heatmap
# plt.imshow(data, cmap='viridis', interpolation='nearest')
# plt.colorbar(label='Value')
# plt.title('Heatmap of V for same potential points')
# plt.xlabel('i for x m away')
# plt.ylabel('j foe x m above')
# plt.xticks(np.arange(10))
# plt.yticks(np.arange(10))
# plt.show()


# #//////
# EPSILON = input("enter volt value of power as a volt:")
# EPSILON=float(EPSILON)

# # Get the last digit of the charge as a string
# C = input("enter capasite of capasitor as farad:")
# C= float(C)
# R = input("enter resistance of circuit as ohm:")
# R= float(R)
# TIMECONSTANT=R*C 
# # second
# t = np.linspace(0,  5*TIMECONSTANT, 1000)
# Q=EPSILON * C * (1 - np.e**(-t / TIMECONSTANT))

# plt.plot(t, Q)

# # Add labels and a title
# plt.xlabel('Time (s)')
# plt.ylabel('Q in capasitor (Coulomb)')
# plt.title('Charging of Capacitor in an RC Circuit')

# # Show the plot
# plt.grid(True)
# plt.show()

# I=(EPSILON/R)*np.e**(-t/TIMECONSTANT)

# plt.plot(t, I)

# # Add labels and a title
# plt.xlabel('Time (s)')
# plt.ylabel('I in Circuit (Amper)')
# plt.title('Changing I in the rime')

# # Show the plot
# plt.grid(True)
# plt.show()

# V=EPSILON*np.e**(-t/TIMECONSTANT)
# plt.plot(t, V)

# # Add labels and a title
# plt.xlabel('Time (second)')
# plt.ylabel('V in the circuit (volt)')
# plt.title('Changing V in the rime')

# # Show the plot
# plt.grid(True)
# plt.show()


# # Function to calculate electric potential at a point due to a point charge
# import numpy as np
# import matplotlib.pyplot as plt

# # Function to calculate electric potential at a point due to a point charge
# def electric_potential(charge, distance):
#     k = 8.9875 * 10**9  # Coulomb's constant in Nm^2/C^2
#     return k * charge / distance

# # Calculate charge based on ID number
# id_number = 2012345673  # Replace this with your actual ID number
# charge = 3 * 10**-9  # Extract last digit

# # Create a 10x10 matrix
# matrix_size = 10
# matrix = np.zeros((matrix_size, matrix_size))

# # Calculate potential at each point in the matrix
# for i in range(matrix_size):
#     for j in range(matrix_size):
#         if i != 0 or j != 0:  # Exclude the point charge itself
#             distance = np.sqrt((i/10)**2 + (j/10)**2)   # Distance in meters
#             matrix[i][j] = electric_potential(charge, distance)

# # Plot 2D image of the matrix
# plt.imshow(matrix, cmap='viridis', origin='lower', extent=[0, 1, 0, 1])
# plt.colorbar(label='Electric Potential (V)')
# plt.title('Electric Potential Matrix')
# plt.xlabel('X-axis (m)')
# plt.ylabel('Y-axis (m)')
# plt.xticks(np.arange(0, 1.1, 0.1))  # Adjust x-axis ticks
# plt.yticks(np.arange(0, 1.1, 0.1))  # Adjust y-axis ticks
# plt.show()

C = 0.00009529
R = 9860
EPSILON = 0.26

# Calculate time constant
TIMECONSTANT = R * C

# Generate time values
t = np.linspace(0, 5* TIMECONSTANT, 10000)

# Calculate voltage over time
V = EPSILON * np.exp(-t / TIMECONSTANT)

# Plot voltage over time
plt.plot(t, V)

# Add a vertical line at 0.00065 seconds with value 0.13 volts
plt.axvline(x=0.65, color='r', linestyle='--', label='V = 0.13 V')

# Add annotations for the value
plt.text(0.00065, 0.13, "(0.00065 s, 0.13 V)", fontsize=9, ha='right', va='bottom')

# Add labels and a title
plt.xlabel('Time (second)')
plt.ylabel('V in the circuit (volt)')
plt.title('Changing V over time')

# Show legend
plt.legend()

# Show the plot
plt.grid(True)
plt.show()