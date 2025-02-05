# 🚍 Smart Bus Card System 💳  

## 📌 Overview  
The **Smart Bus Card System** is a **digital payment solution** for public transportation. It allows users to **swipe in and swipe out**, automatically calculating fares based on:  
- **Distance traveled**  
- **Time of travel** (Day/Night fares)  
- **Available discounts** (Weekend & Long-distance discounts)  

This system ensures a **smooth and hassle-free** commuting experience!  

---

## 🛠️ Features  

✔️ **Swipe In & Swipe Out** – Automatically calculates fare based on travel distance.  
✔️ **Dynamic Fare Calculation** – Different fares for day and night travel.  
✔️ **Weekend Discounts** – Enjoy **20% off** on weekends!  
✔️ **Balance Management** – Check balance and add funds easily.  
✔️ **Minimum Balance Requirement** – Ensures users have enough balance before traveling.  
✔️ **Long-Distance Discount** – **10% discount** for journeys longer than 5 stops.  

---

## 💻 Tech Stack  

- **Java** (Core Logic)  
- **OOP Concepts** (Encapsulation, Inheritance)  
- **Java Time API** (For time-based fare calculation)  

---

## 🚏 How It Works  

### 1️⃣ **Start the System & Select an Option**  
- Press `1` → Travel  
- Press `2` → Check balance / Add balance  
- Press `-1` → Exit  

### 2️⃣ **If Traveling**  
- Enter **Start Stop** (1-15)  
- Enter **End Stop** (Fare is calculated dynamically)  

### 3️⃣ **If Checking Balance**  
- Press `1` → View balance  
- Press `2` → Add funds  

### 4️⃣ **Discounts Applied Based On:**  
✔️ **Time of travel** → Night fares are lower.  
✔️ **Weekend travel** → **20% discount!**  
✔️ **Long-distance travel** → **10% discount beyond 5 stops.**  

---

## 📌 Example Usage  

```sh
------------------------------------
Press 1 to travel
Press 2 for balance details
Press -1 to exit
Enter your choice: 1

Enter start stop (1-15): 3
Swipe-in successful. You may board the bus.

Enter end stop: 8
Swipe-out successful! Journey from stop 3 to stop 8
Fare deducted: ₹3.60
Remaining Balance: ₹6.40
