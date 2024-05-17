package com.cydeo.repository;

import com.cydeo.entity.Account;
import net.bytebuddy.TypeCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findAccountByCountryOrState(String country, String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findAccountByAgeLessThanEqual(Integer age);

    //Write a derived query to list all accounts with a specific role
    List<Account> findAccountByRole(String role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findAccountByAgeBetween(Integer age1, Integer age2);

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findAccountByAddressStartsWith();

    //Write a derived query to sort the list of accounts with age
    List<Account> findAccountByAge(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("SELECT account FROM Account account")
    List<Account> retrieveAllAccounts();

    //Write a JPQL query to list all admin accounts
    @Query("SELECT a FROM Account a WHERE a.role = 'Admin'")
    List<Account> retrieveAllAdminAccounts();

    //Write a JPQL query to sort all accounts with age
    @Query("SELECT a FROM Account a ORDER BY a.age")
    Account retrieveAllAccountWithAgeSorted();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM Account WHERE age < ?1", nativeQuery = true)
    List<Account> retrieveAccountAgeLowerThan(int age);

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country,state city
    @Query(value = "SELECT a FROM Account a HAVING a.name AND a.address AND a.country AND a.state AND a.city", nativeQuery = true)
    List<Account> retrieveAccounts(@Param("name") String name, @Param("address") String address,
                                   @Param("country") String country, @Param("state") String state,
                                   @Param("city") String city);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM Account WHERE age > ?1", nativeQuery = true)
    List<Account> retrieveAccountsWithAgeGreaterThan(int age);

}
