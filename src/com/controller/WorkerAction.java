package com.controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import com.dao.WorkerDao;
import com.entity.Worker;

public class WorkerAction {
	//添加员工信息
	public void addWorkerInformation(JTextField workerIDField,
			JTextField nameField,
			JTextField sexField,
			JTextField ageField,
			JTextField originField,
			JTextField educationField) throws Exception{
		
		WorkerDao workerDao = new WorkerDao();
		Worker worker=new Worker();
		
		worker.setWorker_id(Integer.parseInt(workerIDField.getText()));
		worker.setName(nameField.getText());
		worker.setSex(sexField.getText());
		worker.setAge(ageField.getText());
		worker.setOrigin(originField.getText());
		worker.setEducation(educationField.getText());
		
		workerDao.addWorker(worker);
		
	}
	//删除员工信息
	public void delWorkerInformation(int worker_id) throws Exception {
		WorkerDao workerDao = new WorkerDao();
		workerDao.delWorker(worker_id);
	}
	//修改员工信息
	public void changeWorkerinformation(
			JTextField nameField,
			JTextField sexField,
			JTextField ageField,
			JTextField originField,
			JTextField educationField, JTable table)throws Exception {
		WorkerDao workerDao = new WorkerDao();
		Worker worker =new Worker();
		int selRow = table.getSelectedRow();
		
		int  worker_id= Integer.parseInt(table.getValueAt(selRow, 0).toString());	
		worker.setWorker_id(worker_id);
		worker.setName(nameField.getText());
		worker.setSex(sexField.getText());
		worker.setAge(ageField.getText());
		worker.setOrigin(originField.getText());
		worker.setEducation(educationField.getText());
		
		workerDao.changeWorker(worker);
		
	}
	//查询表信息并放入二维数组中保存
	public Object[][] query(String[] columnNames) throws Exception{
		// TODO Auto-generated method stub
		WorkerDao workerDao = new WorkerDao();
		List<Worker> list = workerDao.query();
		Object[][] results= new Object[list.size()][columnNames.length];
		for (int i = 0; i < list.size(); i++) {
			Worker worker= (Worker)list.get(i);
			
			results[i][0] = worker.getWorker_id();
			results[i][1] = worker.getName();
			results[i][2]=worker.getSex();
			results[i][3]=worker.getAge();
			results[i][4]=worker.getOrigin();
			results[i][5]=worker.getEducation();

			
		}
		return results;
	}
}
