#include "com_example_testrelocatedesctop_nativelib_CreateDescriptionFile.h"
#include <jni.h>
#include <iostream>
#include <windows.h>
#include <aclapi.h>
#include<string>
#include<fstream>
#include<cstring>

using namespace std;

JNIEXPORT void JNICALL Java_com_example_testrelocatedesctop_nativelib_CreateDescriptionFile_NTFSDoc
  (JNIEnv *env, jobject obj, jstring path)
  {
      setlocale(LC_ALL, "Russian");
      const char *res = env->GetStringUTFChars(path, nullptr);
      string path1(res);
      env->ReleaseStringUTFChars(path, res);
      const char* directory = path1.c_str(); // Замените на нужный вам путь к каталогу

      //PrintFileDescriptorsInDirectory(directory);
      WIN32_FIND_DATAA findData;
      HANDLE handle = FindFirstFileA(directory, &findData);
      if (handle == INVALID_HANDLE_VALUE) {
          std::cout << "Error opened file " << directory << std::endl;

      }

      do {
          //if (!(findData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY)) {
          std::string filename = path1;
          filename += "\\";
          filename += findData.cFileName;
          //PrintFileDescriptor(filename.c_str());
          HANDLE handle = CreateFileA(filename.c_str(), GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, FILE_ATTRIBUTE_NORMAL, NULL);
          // if (handle == INVALID_HANDLE_VALUE) {
               //std::cout << "Error opened file " << filename << std::endl;
               //return;
           //}

          PSECURITY_DESCRIPTOR securityDescriptor;
          DWORD descriptorLength = 0;
          GetKernelObjectSecurity(handle, OWNER_SECURITY_INFORMATION | GROUP_SECURITY_INFORMATION | DACL_SECURITY_INFORMATION, NULL, 0, &descriptorLength);
          securityDescriptor = (PSECURITY_DESCRIPTOR)LocalAlloc(LPTR, descriptorLength);
          if (!GetKernelObjectSecurity(handle, OWNER_SECURITY_INFORMATION | GROUP_SECURITY_INFORMATION | DACL_SECURITY_INFORMATION, securityDescriptor, descriptorLength, &descriptorLength)) {
              std::cout << "Error descriprion" << filename << std::endl;
              CloseHandle(handle);
              LocalFree(securityDescriptor);

          }

          PACL dacl;
          BOOL daclPresent, daclDefaulted;
          if (!GetSecurityDescriptorDacl(securityDescriptor, &daclPresent, &dacl, &daclDefaulted)) {
              std::cout << "Error puting DACL for file " << filename << std::endl;
              CloseHandle(handle);
              LocalFree(securityDescriptor);

          }

          std::cout << "File Name: " << filename << std::endl;
          std::cout << "Descriptor file: " << dacl << std::endl;
          std::cout << "----------------------------------" << std::endl;


          string str = path1 + "\\descriptions.txt";
          cout << str;
          ofstream fs;
          fs.open(str, ofstream::app);
          if (!fs.is_open()) {
              cerr << "\nNOT OPENED";
          }
          else {
          fs << "File Name: " << filename << std::endl
             << "Descriptor file: " << dacl << std::endl
             << "----------------------------------" << std::endl;
          }




          CloseHandle(handle);
          LocalFree(securityDescriptor);
          //
          //}
      } while (FindNextFileA(handle, &findData));

      FindClose(handle);
      //
    }
