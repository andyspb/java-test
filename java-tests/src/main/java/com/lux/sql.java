package com.lux;

public class sql {
}
//

//=============================================
//    Employees
//    |ID|Name|Location|
//    |1| John D | Boston |
//    |2| Jenny K| LA |
//    |3| Kelly M | Boston|
//
//
//    Salaries
//    |E_ID| Month| Amount|
//    |1| 'Jun' | 2300|
//    |2| 'Jun' | 2400|
//    |3| 'Jun' | 2500|
//    |3| 'May' | 2100|
//
//    Jun, Boston, 4800
//
//    select Month from Salaries as s inner join select location from Emplyees where ( s.e_id == e.id
//    and e.location== 'Boston' s.Month=='Jun') group by sum(s.Amount);
