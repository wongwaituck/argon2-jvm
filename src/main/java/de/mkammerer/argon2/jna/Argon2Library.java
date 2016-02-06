package de.mkammerer.argon2.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * JNA bindings for Argon2.
 */
public interface Argon2Library extends Library {
    /**
     * Singleton instance.
     */
    Argon2Library INSTANCE = (Argon2Library) Native.loadLibrary("argon2", Argon2Library.class);

    /**
     * Return code if everything is okay.
     */
    int ARGON2_OK = 0;

    /*
    int argon2i_hash_encoded(const uint32_t t_cost, const uint32_t m_cost,
                         const uint32_t parallelism, const void *pwd,
                         const size_t pwdlen, const void *salt,
                         const size_t saltlen, const size_t hashlen,
                         char *encoded, const size_t encodedlen);
     */

    /**
     * Hashes a password with Argon2i, producing an encoded hash.
     *
     * @param t_cost      Number of iterations
     * @param m_cost      Sets memory usage to m_cost kibibytes
     * @param parallelism Number of threads and compute lanes
     * @param pwd         Pointer to password
     * @param pwdlen      Password size in bytes
     * @param salt        Pointer to salt
     * @param saltlen     Salt size in bytes
     * @param hashlen     Desired length of the hash in bytes
     * @param encoded     Buffer where to write the encoded hash
     * @param encodedlen  Size of the buffer (thus max size of the encoded hash)
     * @return ARGON2_OK if successful
     */
    int argon2i_hash_encoded(Uint32_t t_cost, Uint32_t m_cost, Uint32_t parallelism, byte[] pwd, Size_t pwdlen, byte[] salt, Size_t saltlen, Size_t hashlen, byte[] encoded, Size_t encodedlen);


    /**
     * Hashes a password with Argon2i, producing a raw hash
     *
     * @param t_cost Number of iterations
     * @param m_cost Sets memory usage to 2^m_cost kibibytes
     * @param parallelism Number of threads and compute lanes
     * @param pwd Pointer to password
     * @param pwdlen Password size in bytes
     * @param salt Pointer to salt
     * @param saltlen Salt size in bytes
     * @param hash Buffer where to write the raw hash
     * @param hashlen Desired length of the hash in bytes
     * @return ARGON2_OK if successful
     */
    int argon2i_hash_raw(Uint32_t t_cost, Uint32_t m_cost,
                         Uint32_t parallelism, byte[] pwd,
                         Size_t pwdlen, byte[] salt,
                         Size_t saltlen, byte[] hash, Size_t hashlen);


    /**
     * Verifies a password against an encoded string
     *
     * @param encoded String encoding parameters, salt, hash
     * @param pwd Pointer to password
     * @param pwdlen Password size in bytes
     * @return ARGON2_OK if successful
     */
    /*
    int argon2i_verify(const char *encoded, const void *pwd, const size_t pwdlen);
     */
    int argon2i_verify(byte[] encoded, byte[] pwd, Size_t pwdlen);
}
