package com.scada.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DataBackup {

	/**
	 * �������ݿ�
	 * @param databaseFilePath ���ݵ�·��
	 */
	public static void backup(String databaseFilePath) {
        try {
            Runtime rt = Runtime.getRuntime();
 
            // ���� mysql �� cmd:
            //mysqldump -uroot -proot --set-charset=utf8 scada
            Process child = rt
                    .exec("mysqldump -u"+new ReadProperties().getProperties("db.properties", "jdbc.user")
                    		+" -p"+new ReadProperties().getProperties("db.properties", "jdbc.password")+" --set-charset=utf8 scada");// ���õ�������Ϊutf8�����������utf8
 
            // �ѽ���ִ���еĿ���̨�����Ϣд��.sql�ļ����������˱����ļ���ע��������Կ���̨��Ϣ���ж�������ᵼ�½��̶����޷�����
            InputStream in = child.getInputStream();// ����̨�������Ϣ��Ϊ������
 
            InputStreamReader xx = new InputStreamReader(in, "utf8");// �������������Ϊutf8�����������utf8����������ж����������
 
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // ��Ͽ���̨�����Ϣ�ַ���
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            // Ҫ�����������õ�sqlĿ���ļ���
            FileOutputStream fout = new FileOutputStream(
            		databaseFilePath+"scada.sql");
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
            writer.write(outStr);
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
            writer.flush();
 
            // �����ǹر����������
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
 
            System.out.println("/* Output OK! */");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
	
	
	
	/**
	 * ��ԭ���ݿ�
	 * @param databaseFilePath ��ԭ��·��
	 */
    public static void load(String databaseFilePath) {
        try {
            String fPath = databaseFilePath+"scada.sql";
            Runtime rt = Runtime.getRuntime();
 
            // ���� mysql �� cmd:
        //    rt.exec("create database demo");
            Process child = rt.exec("mysql -uroot -proot demo");
            OutputStream out = child.getOutputStream();// ����̨��������Ϣ��Ϊ�����
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fPath), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
 
            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            // ע����������û��巽ʽд���ļ��Ļ����ᵼ���������룬��flush()��������Ա���
            writer.flush();
            // �����ǹر����������
            out.close();
            br.close();
            writer.close();
 
            System.out.println("/* Load OK! */");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
